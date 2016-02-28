import java.util.ArrayList;

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

    ArrayList arr = new ArrayList();
    public benchImplicit(ArrayList arr){

    this.arr = arr;
   


    }

    public long test1() {

        long start = System.nanoTime();

        arr.parallelStream()
                .sorted();
        long finish = System.nanoTime();
        return finish - start;
    }


    }


