import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chris on 10/12/2015.
 *
 * This class explicitly defines threads to sort smaller sections of the ArrayList. After these
 * smaller sections have been sorted the thread pool then reconnects these segments and sorts
 * the complete ArrayList.
 */
class benchExplicit implements Runnable {


    ArrayList<Integer> arr;
    List<Integer> arr1 = new ArrayList<Integer>();
    List<Integer> arr2;
    List<Integer> arr3;
    List<Integer> arr4;
    
    boolean release = false;
    public double result;

    public benchExplicit(ArrayList<Integer> arr){

        this.arr = arr;
        int  section = arr.size() / 4;

        arr1 = this.arr.subList(0, section);
        arr2 = this.arr.subList(section,section*2);
        arr3 = this.arr.subList(section*2,section*3);
        arr4 = this.arr.subList(section*3,section*4);


    }


    public  List<Integer> sort( List<Integer> arr12) {

        release = true;
        while (release) {
            release = false;
            for (int i = 1; i < arr12.size()-1; i++) {

                int temp;
                for( int k=0; k<arr12.size()-1; k++ ) {
                    for ( int j=k+1; j<arr12.size(); j++ ){
                        if( arr12.get(j) < arr12.get(k) ) {
                            temp = arr12.get(k);
                            arr12.set(k,arr12.get(j));
                            arr12.set(j,temp);
                        }
                    }
                }
            }
        }

        return arr12;
    }

    public void run() {
        long start = System.nanoTime();
        Thread thread1 = new Thread(new Runnable(){

            @Override
            public void run() {
                sorter s = new sorter(arr1);

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
                sorter s = new sorter(arr2);

               }

        });
        thread2.start();
        try {
            thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Thread thread3 = new Thread(new Runnable(){

            @Override
            public void run() {
                sorter s = new sorter(arr3);

               }

        });
        thread3.start();
        try {
            thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Thread thread4 = new Thread(new Runnable(){

            @Override
            public void run() {
                sorter s = new sorter(arr4);
               }

        });
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<Integer> temp = new ArrayList<Integer>();
        temp.addAll(arr1);
        temp.addAll(arr2);
        temp.addAll(arr3);
        temp.addAll(arr4);

        sorter s = new sorter(temp);

        long finish = System.nanoTime();
        double seconds = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS) / 1000.0;

        result = seconds;


    }


}
