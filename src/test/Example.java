package test;

import java.util.HashMap;

public class Example {
    private static volatile Example example;

    public Example example(){
        if(example == null){
            synchronized (Object.class){
                if(example == null){
                    example = new Example();
                }
            }
        }
        return example;
    }

}
