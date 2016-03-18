/**
 * Created by Chris on 09/03/2016.
 *
 * Interface with default method containing a simple solution to check
 * if a number is a prime number.
 *
 */
public interface prime {

    default boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)return false;
        }
        return true;
    }

}



