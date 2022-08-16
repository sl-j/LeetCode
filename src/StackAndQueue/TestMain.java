package StackAndQueue;

public class TestMain {
    public int test() {
        int a = 0;
        try {
            a++;
            throw new Exception("故意的");
        }
        catch (Exception exa) {
            a++;
            return a;
        }
        finally{
            a++;
            System.out.println("a1 = " + a);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = new TestMain().test();
        System.out.println("a2 = " + a);
    }
}