import java.util.ArrayList;
import java.util.Collections;

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
     * @return long
     */

    public long test1() {

        long start = System.nanoTime();

        boolean release = true;
        while (release) {
            release = false;
            for (int x = 1; x < arr.size()-1; x++) {

                int temp;
                for( int y=0; y<arr.size()-1; y++ ) {
                    for ( int z=y+1; z<arr.size(); z++ ){
                        if( arr.get(z) < arr.get(y) ) {
                            temp = arr.get(y);
                            arr.set(y,arr.get(z));
                            arr.set(z,temp);
                        }
                    }
                }
            }
        }


        long finish = System.nanoTime();
        return finish - start;
    }


}
