import java.util.ArrayList;
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

    ArrayList arr = new ArrayList();
    public benchImplicit(ArrayList arr){

    this.arr = arr;
   


    }

    public double test1() {

        long start = System.nanoTime();

        arr.parallelStream()
                .sorted();
        long finish = System.nanoTime();

        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        return seconds;
    }


    }


