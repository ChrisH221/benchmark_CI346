import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chris Howell on 10/12/2015.
 *
 * This class takes an ArrayList as an input and uses the prime interface to
 * count the prime numbers.
 *
 */
public class benchNon implements prime{

    List<Integer> arr;

    public benchNon(ArrayList<Integer> arr){

        this.arr = arr;
    }

    public double test() {


      long start = System.nanoTime();
      long count=0;

      for(int x = 0; x < arr.size();x++){

          if(isPrime(arr.get(x))) count+=1;

      }
        System.out.println("Total number of prime numbers found=" + count);
        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        return seconds;
    }

}


