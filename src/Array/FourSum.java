package Array;


import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class FourSum extends Thread{
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #
     */
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("run");

    }

    public static void main(String[] args) {
       FourSum fourSum = new FourSum();
       fourSum.run();
        System.out.println("main");
    }


}
