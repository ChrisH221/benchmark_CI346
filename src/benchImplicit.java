import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chris Howell on 10/12/2015.
 *
 * The benchImplicit Class is the benchmark class that implements a parallel stream
 * to test implicit concurrency.
 *
 * This class takes an ArrayList and uses a parallel stream to sort the ArrayList
 * before returning the times.
 */
public class benchImplicit {

    ArrayList arr = new ArrayList<Integer>();
    ArrayList arr2 = new ArrayList();
    public benchImplicit(ArrayList arr){

    this.arr = arr;

    }

    public double test1() {

        long start = System.nanoTime();



            arr.parallelStream().sorted(new BubblesortListSorter(arr));


        long finish = System.nanoTime();

        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        return seconds;
    }


    @SuppressWarnings("unchecked")
    public  class BubblesortListSorter implements Comparator<Integer> {

        public BubblesortListSorter(ArrayList<Integer> arr){

            sort(arr);

        }

        public int compare(Integer o1, Integer o2) {
           if(o1 < o2) return 01;
           else return 02;
        }

        List<Integer> sort(List<Integer> arr){
            int temp;
            for( int y=0; y<arr.size()-1; y++ ) {
                for ( int z=y+1; z<arr.size(); z++ ){
                    if(compare(arr.get(z),arr.get(y) ) == 1 ) {
                        temp = arr.get(y);
                        arr.set(y,arr.get(z));
                        arr.set(z,temp);
                    }
                }
            }

            return arr;
        }
    }

    }


