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

    public benchMark(){

        Random randomGenerator = new Random();
        for (int idx = 1; idx <=3000; ++idx){
            int randomInt = randomGenerator.nextInt(10000);
            arr.add(randomInt);
           
        }

    }
    
    public void setupBench(){


    	for(Integer i : arr) {
    	    arr1.add(i);
    	}
    	
    	for(Integer i : arr) {
    	    arr2.add(i);
    	}
    	 
    	for(Integer i : arr) {
    	    arr3.add(i);
    	}

        for(Integer i : arr) {
            arr4.add(i);
        }




    }
    
    public void runBench(){
    	
       
        benchForLoop bfl = new benchForLoop(arr);
     //   System.out.println("benchForLoop test time = " + bfl.test1());
        benchExplicit bex = new benchExplicit(arr);
    //    bex.run();
        benchThreadPool btp = new benchThreadPool(arr);
        System.out.println("benchThreadPool test time = " +btp.test());
     //   System.out.println("benchExplicit test time = " + bex.result);
        benchImplicit bIm = new benchImplicit(arr);
        System.out.println("benchImplicit test time = " + bIm.test1());

    	
    }


    public static void main (String[] args){
    	
    	 
    	
        benchMark b = new benchMark();
     //   b.setupBench();
        b.runBench();
        
        
    


    }
}
