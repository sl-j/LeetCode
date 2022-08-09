package Array;

public class Singeton {
    private static class Singetor{
        private final static Singeton INSTANCE = new Singeton();
    }

    public static Singeton getSin(){
        return Singetor.INSTANCE;
    }

}
