import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by chris on 27/02/16.
 *
 * The thread pool class features an inner class which represents the worker
 * thread process for this class. The main thread pool class calculates the
 * number of cores, then generates the appropriate number of threads. Afterwards,
 * it handles the lifetime of a thread while it completes it's operation. A Thread Pool
 * Executor handles the thread creations and execution.
 */
public class benchThreadPool implements prime {

    ArrayList<List<Integer>> arr = new ArrayList<>();

    boolean release = false;
    int cores = Runtime.getRuntime().availableProcessors();
     long count = 0;


    public benchThreadPool(ArrayList<Integer> arr1){
        int  section = arr1.size() / cores;

        int increment = 0;
        int y = 2;


        for(int x = 0; x < cores; x++){

            if(x == 0){
                List<Integer> temp = arr1.subList(increment*section,(section));
                arr.add(temp);
                increment++;
            }
            else{
                List<Integer> temp = arr1.subList(increment*section,section*y);
                arr.add(temp);
                increment++;
                y++;
            }

        }


    }

    public double test(){

        long start = System.nanoTime();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(cores);

        List<Future<Long>> results = new ArrayList<>();

        for (int i=0; i<executor.getCorePoolSize(); i++)
        {
            worker work  = new worker(arr.get(i));
            Future<Long> result = executor.submit(work);
            results.add(result);
        }


        for(Future<Long> future : results)
        {
            try
            {
               count += future.get();//Get's the value from the worker, but blocks the thread while it does.
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        System.out.println("Total number of prime numbers found=" + count);
        return seconds;


    }

    class worker implements Callable<Long>
    {

        List<Integer> work;

        public worker(List<Integer> work){


            this.work = work;

        }

        @Override
        public Long call() throws Exception{

            long thisCount =0;

            for(Integer num : work)  if(isPrime(num))  thisCount+=1;

            return thisCount;
        }
    }

}