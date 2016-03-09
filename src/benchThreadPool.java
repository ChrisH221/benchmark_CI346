import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by chris on 27/02/16.
 *
 * The thread pool class features an inner class which represents the worker
 * thread process for this class. The main thread pool class calculates the
 * number of cores, then generates the appropriate number of threads. Afterwards,
 * it handles the lifetime of a thread while it completes it's operation.
 */
public class benchThreadPool {

    ArrayList<List<Integer>> arr = new ArrayList<>();

    boolean release = false;
    int cores = Runtime.getRuntime().availableProcessors();
    List<Integer> sorted =  new ArrayList<>();


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
       // arr.get(0).forEach(x-> System.out.println(x));

    }

    public double test(){

        long start = System.nanoTime();




        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(cores);

        List<Future<List<Integer>>> resultList = new ArrayList<>();

        for (int i=0; i<cores; i++)
        {

            worker work  = new worker(arr.get(i));
            Future<List<Integer>> result = executor.submit(work);
             resultList.add(result);
        }


        for(Future<List<Integer>> future : resultList)
        {
            try
            {
              //  System.out.println(future.get());
                sorted.addAll(future.get());
              //  future.get().forEach(x -> System.out.println(x));



            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }

        executor.shutdown();

       sorter s = new sorter(sorted);

        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;

        return seconds;


    }







    class worker implements Callable<List<Integer>>
    {
        List<Integer> sorted = new ArrayList<>();
        final List<Integer> arr1 = new ArrayList<>();
        List<Integer> work;
        boolean release = false;


        public worker(List<Integer> work){


            this.work = work;

        }






        @Override
        public List<Integer> call() throws Exception {
            List<Integer> sort = work;
             sorter s = new sorter(sort);
             sorted.addAll(sort);

            return  sorted;
        }
    }

}

