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
public class benchImplicit implements sorter {

    List<Integer> arr = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    boolean release = false;
    int cores = Runtime.getRuntime().availableProcessors();
    List<Integer> sorted =  new ArrayList<>();


    public benchImplicit(ArrayList<Integer> arr1){
        int  section = arr1.size() / cores;
        this.arr = arr1;
 //       int increment = 0;
//      int y = 2;


//        for(int x = 0; x < cores; x++){

            //if(x == 0){
               // List<Integer> temp = arr1.subList(increment*section,(section));
               // arr.add(temp);
              //  increment++;
            //}
           // else{
             //   List<Integer> temp = arr1.subList(increment*section,section*y);
           //     arr.add(temp);
       //         increment++;
         //       y++;
     //       }

   //     }
        // arr.get(0).forEach(x-> System.out.println(x));

    }

    public double test1() {

        long start = System.nanoTime();

        long count = arr.parallelStream().filter(x -> (isPrime(x))).count();

        System.out.println(count);
        long finish = System.nanoTime();

        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        return seconds;
    }



    }


