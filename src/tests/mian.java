package tests;

import com.sun.javafx.sg.prism.NGRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class mian {

    private static float PI = (float) 3.1415927;
    public static void main(String[] args) throws IOException {
        countExcellentPairs(new int[]{1,2,3,1},3);

    }

    public static long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
                int count = Integer.bitCount(num);
                map.put(count,map.getOrDefault(count,1) + 1);
            }
        }

        long ans = 0;
        for(int value1 : map.keySet()){
            for(int value2 : map.keySet()){
                if(map.get(value1) + map.get(value2) >= k){
                    ans += map.get(value1) * map.get(value2) ;
                }
            }
        }




        return ans;
    }
}
