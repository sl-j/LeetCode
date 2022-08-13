package Array;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;

public class Singeton {
    private static class Singetor{
        private final static Singeton INSTANCE = new Singeton();
    }

    public static Singeton getSin(){
        return Singetor.INSTANCE;
    }

}
