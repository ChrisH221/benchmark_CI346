import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chris Howell on 10/12/2015.
 *
 * The benchImplicit Class is the benchmark class that implements a parallel stream
 * to test implicit concurrency.
 *
 *
 */
public class benchImplicit implements prime {

    List<Integer> arr = new ArrayList<>();
    public benchImplicit(ArrayList<Integer> arr){
    this.arr = arr;

    }


    public double test() {

        long start = System.nanoTime();

        long count = arr.parallelStream()
                                         .filter(x -> (isPrime(x)))
                                         .count();

        System.out.println("Total number of prime numbers found="+count);
        long finish = System.nanoTime();

        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        return seconds;
    }



}