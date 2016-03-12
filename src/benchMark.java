import java.util.Random;
import java.util.ArrayList;

/**
 * Created by Chris on 10/12/2015.
 *
 * The main benchmark class for the application is responsible for initializing the
 * various classes and running the tests contained in these classes. It also prints
 * each of the resulting test times.
 */
public class benchMark {

    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<Integer> arr1 = new ArrayList<>();
	 ArrayList<Integer> arr2 = new ArrayList<>();
	 ArrayList<Integer> arr3 = new ArrayList<>();
    ArrayList<Integer> arr4 = new ArrayList<>();
    boolean setup = false;
    public benchMark(){

        Random randomGenerator = new Random();
        for (int idx = 1; idx <=100000; ++idx){
            int randomInt = randomGenerator.nextInt(100);
            arr.add(randomInt);
           
        }

    }
    
    public void setupBench(){

        arr.forEach(x -> arr1.add(x));
        arr.forEach(x -> arr2.add(x));
        arr.forEach(x -> arr3.add(x));
        arr.forEach(x -> arr4.add(x));
        setup = true;

    }



    public void runBench(){

        benchForLoop bfl = new benchForLoop(arr2);
        System.out.println("benchForLoop test time = " + bfl.test1());

        benchImplicit bIm = new benchImplicit(arr1);

        System.out.println("benchImplicit test time = " + bIm.test1());


        benchExplicit bex = new benchExplicit(arr3);
        bex.run();
        System.out.println("benchExplicit test time = " + bex.result);
        benchThreadPool btp = new benchThreadPool(arr4);
       System.out.println("benchThreadPool test time = " +btp.test());



    	
    }
    public void run(){


       setupBench();

        while(setup){
            runBench();
            setup = false;        }

    }

    public static void main (String[] args){


        benchMark b = new benchMark();
        b.run();

        
        
    


    }
}
