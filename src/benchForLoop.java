import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chris Howell on 10/12/2015.
 *
 * This class takes an ArrayList and using a for loop sorts the array.
 *
 */
public class benchForLoop implements sorter{

    List<Integer> arr;



    public benchForLoop(ArrayList<Integer> arr){

        this.arr = arr.subList(0,arr.size()-1);
    }

    /**
     * The test method for this class takes the ArrayList and sorts it before
     * returning the time it took to sort.
     * @return double
     */

    public double test1() {


      long start = System.nanoTime();


      arr = sort(arr);


        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        return seconds;
    }





}
