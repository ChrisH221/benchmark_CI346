import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 10/12/2015.
 *
 * This class explicitly defines threads to sort smaller sections of the ArrayList. After these
 * smaller sections have been sorted the thread pool then reconnects these segments and sorts
 * the complete ArrayList.
 */
class benchExplicit implements Runnable {


    ArrayList<Integer> arr;
    List<Integer> arr1;
    List<Integer> arr2;
    List<Integer> arr3;
    List<Integer> arr4;
    
    boolean release = false;
    public long result;

    public benchExplicit(ArrayList<Integer> arr){

        this.arr = arr;
        int  section = arr.size() / 4;
        arr1 = this.arr.subList(0, section-1);
        arr2 = this.arr.subList(section,section*2-1);
        arr3 = this.arr.subList(section*2,section*3-1);
        arr4 = this.arr.subList(section*3,section*4-1);

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Thread thread3 = new Thread(new Runnable(){

            @Override
            public void run() {
               arr3 = sort(arr3);

               }

        });
        thread3.start();
        try {
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Thread thread4 = new Thread(new Runnable(){

            @Override
            public void run() {
               arr4 = sort(arr4);

               }

        });
        thread4.start();
        try {
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<Integer> temp = null;
        temp.addAll(arr1);
        temp.addAll(arr2);
        temp.addAll(arr3);
        temp.addAll(arr4);
        
        arr = (ArrayList<Integer>) sort(temp);
       
        for(int x =0; x < arr.size(); x++)System.out.println(arr.get(x));
        
        long finish = System.nanoTime();
       



    }


}
