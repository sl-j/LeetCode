package sort;

import java.util.Date;

public class main {
    private final static Object o1 = new Object();
    private final static Object o2 = new Object();
    public static class A extends Thread{
        @Override
        public void run() {
            try {
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName() + "获取锁,尝试获取锁b");
                    Thread.sleep(1000);
                    synchronized (o2){
                        System.out.println(Thread.currentThread().getName() + "获取到锁a");
                    }
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
            }catch (Exception e){

            }
        }
    }

    public static class B extends Thread{
        @Override
        public void run() {
            try {
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "获取锁,尝试获取锁a");
                    Thread.sleep(1000);
                    synchronized (o1){
                        System.out.println(Thread.currentThread().getName() + "获取到锁B");
                    }
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new A();
        Thread t2= new B();

        t1.start();
        t2.start();


    }
}
