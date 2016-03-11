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

    boolean release = false;
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
                arr1 = sort(arr1);

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
                arr2 = sort(arr2);

            }

        });
        thread2.start();
        try {
              thread2.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }


        List<Integer> temp = new ArrayList<Integer>();
        temp.addAll(arr1);
        temp.addAll(arr2);


        arr = (ArrayList<Integer>) sort(temp);
        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;

        result = seconds;


    }


}
