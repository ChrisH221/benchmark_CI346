import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    int cores;
    boolean release = false;

    public benchThreadPool(ArrayList<Integer> arr1){

        int cores = Runtime.getRuntime().availableProcessors();
        this.cores = cores;
        int  section = arr1.size() / cores;
        int increment = 0;
        int y = 1;

        for(int x = 0; x < cores-1; x++){
            List<Integer> temp = arr1.subList(increment*section,(section-1)*y);
             arr.add(temp);
             x++;
        }

    }

    public long test(){

        long start = System.nanoTime();
        ArrayList<List<Integer>> arr = new ArrayList<>();
        List<Integer> sorted =  new ArrayList<>();

        for(int x = 0; x < arr.size()-1; x++){

            List<Integer> temp =arr.get(x);

            worker work = new worker(temp);
            work.run();
            List<Integer> temp2 = work.getArr();
            sorted.addAll(temp2);

        }
        List<Integer> complete = sort(sorted);
        long finish = System.nanoTime();
        long result = finish - start;
        return result;

    }


    public  List<Integer> sort( List<Integer> arr12) {

        release = true;
        while (release) {
            release = false;
            for (int i = 1; i < arr12.size()-1; i++) {

                int temp;
                for( int k=0; k<arr12.size()-1; k++ ) {
                    for ( int j=k+1; j<arr12.size(); j++ ){
                        if( arr12.get(j) < arr12.get(k) ) {
                            temp = arr12.get(k);
                            arr12.set(k,arr12.get(j));
                            arr12.set(j,temp);
                        }
                    }
                }
            }
        }

        return arr12;
    }




    class worker implements Runnable{

        final List<Integer> arr1 = new ArrayList<>();
        List<Integer> work;
        boolean release = false;

        public worker(List<Integer> work){

        this.work = work;

        }


        @Override
        public void run() {

            arr1.addAll(sort(work));

            for(int x =0; x < arr1.size();x++) System.out.println(arr1.get(x));
        }

        public List<Integer> getArr(){

            return arr1;

        }


        public  List<Integer> sort( List<Integer> arr12) {

            release = true;
            while (release) {
                release = false;
                for (int i = 1; i < arr12.size()-1; i++) {

                    int temp;
                    for( int k=0; k<arr12.size()-1; k++ ) {
                        for ( int j=k+1; j<arr12.size(); j++ ){
                            if( arr12.get(j) < arr12.get(k) ) {
                                temp = arr12.get(k);
                                arr12.set(k,arr12.get(j));
                                arr12.set(j,temp);
                            }
                        }
                    }
                }
            }

            return arr12;
        }

    }


}

