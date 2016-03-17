import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chris Howell on 10/12/2015.
 *
 * This class takes an ArrayList as an input and then sorts it using the sorter
 * interface default method.
 *
 */
public class benchNon implements sorter{

    List<Integer> arr;
    List<Integer> temp = new ArrayList<>();


    public benchNon(ArrayList<Integer> arr){

        this.arr = arr.subList(0,arr.size());
    }

    /**
     * The test method for this class takes the ArrayList and sorts it before
     * returning the time it took to sort.
     * @return double
     */

    public double test1() {


      long start = System.nanoTime();
      long count=0;
      ;
      // q.sort(arr);
      for(int x = 0; x < arr.size();x++){

          if(isPrime(arr.get(x))) count+=1;

      }

       System.out.println(count);

        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        return seconds;
    }

    public double test2(){

        long start = System.nanoTime();

        arr.forEach(x -> {if(isPrime(x)) temp.add(x);});

        System.out.println(temp.size());

        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        return seconds;


    }


}


