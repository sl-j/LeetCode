package StackAndQueue;

import sun.security.krb5.internal.CredentialsUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.locks.LockSupport;

public class main {
    private static Thread t1 = null,t2 = null;

    public static void main(String[] args) throws IOException {
        int[] nums = new int[]{1,2,3};
        char[] chars = new char[]{'a','b','c'};
        t1 = new Thread( () ->{
            for(int num : nums){
                LockSupport.park();
                System.out.println(num);
                LockSupport.unpark(t2);
            }
        },"t1");

        t2 = new Thread( () ->{
            for(char ch : chars){
                LockSupport.park();
                System.out.println(ch);
                LockSupport.unpark(t1);
            }
        },"t2");

        t1.start();
        t2.start();
        LockSupport.unpark(t1);
    }




}
