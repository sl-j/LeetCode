package Array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    /* Write Code Here */
    public static int findMinDifference(String[] timePoints) {
        int res = 24*62;

        for(int i = 0;i < timePoints.length;i++){
            for(int j = i + 1;j < timePoints.length;j++){
                res = Math.min(res,help(timePoints[i],timePoints[j]));
            }
        }

        return res;

    }

    private static int help(String s1,String s2){
        int num1 = Integer.parseInt(s1.substring(3,s1.length()));
        int num2 = Integer.parseInt(s2.substring(3,s2.length()));
        int max = 24*60;

        int num3 = Integer.parseInt(s1.substring(0,2));
        int num4 = Integer.parseInt(s2.substring(0,2));

        int n1 = num3 * 60 + num1;
        int n2 = num4 * 60 + num2;

        if(n1 < n2){
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }

        return Math.min(n1- n2,max - n1 + n2);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int timePoints_size = 0;
        timePoints_size = in.nextInt();
        if (in.hasNextLine())
            in.nextLine();
        String[] timePoints = new String[timePoints_size];
        String timePoints_item;
        for(int timePoints_i = 0; timePoints_i < timePoints_size; timePoints_i++) {
            try {
                timePoints_item = in.nextLine();
            } catch (Exception e) {
                timePoints_item = null;
            }
            timePoints[timePoints_i] = timePoints_item;
        }

        res = findMinDifference(timePoints);
        System.out.println(String.valueOf(res));

    }
}