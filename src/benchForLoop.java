import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chris Howell on 10/12/2015.
 *
 * This class takes an ArrayList and using a for loop sorts the array.
 *
 */
public class benchForLoop{

    ArrayList<Integer> arr;



    public benchForLoop(ArrayList<Integer> arr){

        this.arr = arr;
    }

    /**
     * The test method for this class takes the ArrayList and sorts it before
     * returning the time it took to sort.
     * @return double
     */

    public double test1() {
        int count = 0;
      long start = System.nanoTime();

        sorter s = new sorter(arr);
      // boolean release = true;
     //   while (release) {
      //      release = false;
       //     for (int x = 1; x < arr.size()-1; x++) {

        //        int temp;
        //        for( int y=0; y<arr.size()-1; y++ ) {
         //           for ( int z=y+1; z<arr.size(); z++ ){
        //                if( arr.get(z) < arr.get(y) ) {
         //                   temp = arr.get(y);
          //                  arr.set(y,arr.get(z));
           //                 arr.set(z,temp);
          //              }
         //           }
        //        }
         //       count++;
        //        System.out.println(count);
        //    }
     //   }



        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;
        return seconds;
    }





}
