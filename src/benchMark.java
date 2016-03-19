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
        for (int randNum = 1; randNum <=100000; ++randNum){
            int randomInt = randomGenerator.nextInt(100);
            arr.add(randomInt);
           
        }

    }
   /*
    */
    public void bench1(){
        arr.forEach(x -> arr1.add(x));
        benchNon bfl = new benchNon(arr1);
        System.out.println("benchNon test time = " + bfl.test());
        arr1 = null; // Run out of memory if array isn't readied for garbage collection
    }

    public void bench2(){
        arr.forEach(x -> arr2.add(x));
        benchImplicit bIm = new benchImplicit(arr2);
        System.out.println("benchImplicit test time = " + bIm.test());
        arr2 = null;
    }

    public void bench3(){
        arr.forEach(x -> arr3.add(x));
        benchThreadPool btp = new benchThreadPool(arr3);
        System.out.println("benchThreadPool test time = " +btp.test());
        arr3 = null;
    }

    public void bench4(){
        arr.forEach(x -> arr4.add(x));
        benchExplicit bex = new benchExplicit(arr4);
        bex.run();
        while(!bex.complete) {//Make sure both threads have exected before getting result.
        }
        System.out.println("benchExplicit test time = " + bex.result);
        arr4 = null;
    }


    public void runBench(){

        bench1();
        bench2();
        bench3();
        bench4();

    }


    public static void main(String[] args){
        benchMark b = new benchMark();
        b.runBench();
    }
}
