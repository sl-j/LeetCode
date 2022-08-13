package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Random;

public class t {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char[] chars = str.toCharArray();
        Random random = new Random();

        boolean flag = false;
        swap(chars,0,random.nextInt(chars.length));
        for(int i = 1;i < chars.length;i++){
            int count = 0;
            while(chars[i] == chars[i - 1]){
                count++;
                int index = i + random.nextInt(chars.length - i);
                swap(chars,i,index);
                if(count > 5){
                    flag = true;
                    break;
                }
            }
        }

        if(flag){
            System.out.println("no");
        }else{
            System.out.println("yes");
            System.out.println(String.valueOf(chars));
        }
    }


    private static void swap(char[] chars,int i,int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
