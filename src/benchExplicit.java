import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chris on 10/12/2015.
 *
 * This class explicitly defines threads to sort smaller sections of the ArrayList. After these
 * smaller sections have been sorted the thread pool then reconnects these segments and sorts
 * the complete ArrayList.
 */
class benchExplicit implements Runnable,sorter {


    ArrayList<Integer> arr;
    List<Integer> arr1;
    List<Integer> arr2;

    long count = 0;
    public double result;

    public benchExplicit(ArrayList<Integer> arr){

        this.arr = arr;
        int  section = arr.size() / 2;

        arr1 = this.arr.subList(0, section);
        arr2 = this.arr.subList(section,section*2);

    }





    public void run() {
        long start = System.nanoTime();
        Thread thread1 = new Thread(new Runnable(){

            @Override
            public void run() {

                for(int x = 0; x < arr1.size();x++){

                    if(isPrime(arr1.get(x))) count+=1;

                }

            }

        });
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread thread2 = new Thread(new Runnable(){

            @Override
            public void run() {

                for(int x = 0; x < arr2.size();x++){

                    if(isPrime(arr2.get(x))) count+=1;

                }

            }

        });
        thread2.start();
        try {
              thread2.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }



        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;

       System.out.println(count);
        result = seconds;


    }


}
