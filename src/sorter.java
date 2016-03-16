
import java.util.List;

/**
 * Created by Chris on 09/03/2016.
 *
 * Interface with default method for sorting a list of integers
 * using bubble sort.
 *
 */
public interface sorter {


        default List<Integer> sort(List<Integer> arr){
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
            return arr;
    }

    default boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

}



