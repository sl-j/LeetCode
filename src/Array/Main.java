package Array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int[][] value = new int[m][3];


        int index = 0;
        for(int i = 0;i < 3;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = 0;j < tmp.length;j++){
                value[j][i] = Integer.parseInt(tmp[j]);
            }
        }

        System.out.println(slove(value,n));

    }

    private static long slove(int[][] value,int n){
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1,int[] o2) -> o1[2] - o2[2]);
        for(int[] num : value){
            queue.offer(num);
        }

        Set<Integer> set = new HashSet<>();
        long res = 0;
        while(!queue.isEmpty()){
            int[] num = queue.poll();
            int v = num[0];
            int u = num[1];
            if(set.contains(v) && set.contains(u)) continue;
            res += num[2];
            set.add(v);
            set.add(u);

            if(set.size() == n) break;
        }

        return res;
    }




}