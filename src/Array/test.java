package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = Integer.parseInt(str);
        while(n > 0){
            String[] s = br.readLine().split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);

            dfs(a,b);
            System.out.println(res);
            n--;
        }
    }

    private static void dfs(long a,long b){
        if(a <= 0 || b <= 0) return;

        if(a < b){
            a--;
            b -=2;
        }else{
            b--;
            a-=2;
        }
        if(a < 0 || b < 0) return;
        res++;
        dfs(a,b);
    }
}
