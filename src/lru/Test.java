package lru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        long[][] arr = new long[n][m];
        int row = 0;

        while(row < n){
            String[] s = br.readLine().split(" ");
            for(int j = 0;j < m;j++){
                arr[row][j] = Long.parseLong(s[j]);
            }
            row++;
        }
        long ans = 0;
        for(int i = 1;i < n;i++){
            ans = Math.max(ans,findAns(arr,i));
        }
        System.out.println(ans);


    }

    private static long findAns(long[][] arr,int n){
        long row = arr.length;
        long clo = arr[0].length;
        long ans = 0;
        for(int i = 0;i + n < row;i++){
            for(int j = 0;j + n < clo;j++){
                ans = Math.max(ans,arr[i][j] + arr[i][j + n] + arr[i + n][j] + arr[i + n][j + n]);
            }
        }
        return ans;
    }

//        minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int s = Integer.parseInt(br.readLine());
//        while(s > 0){
//            int t = Integer.parseInt(br.readLine());
//            String str = br.readLine();
//            int[] count = new int[str.length()];
//
//            for(int i = 0;i < str.length();i++){
//                count[i] = str.charAt(i) - '0';
//            }
//            int num = Integer.parseInt(br.readLine());
//            char[] chars = br.readLine().toCharArray();
//
//            PriorityQueue<Integer> queue0 = new PriorityQueue<>();
//            PriorityQueue<Integer> queue1 = new PriorityQueue<>();
//
//            for(int i = 0;i < count.length;i++){
//                if(count[i] == 0) queue0.offer(i);
//                else if(count[i] == 1) queue1.offer(i);
//            }
//
//            int[] ans = new int[chars.length];
//
//            for(int i = 0;i < chars.length;i++){
//                if(chars[i] == 'M'){
//                    if(!queue1.isEmpty()){
//                        ans[i] = queue1.poll() + 1;
//                    }else{
//                        ans[i] = queue0.peek() + 1;
//                        queue1.offer(queue0.poll());
//                    }
//                }else{
//                    if(!queue0.isEmpty()){
//                        ans[i] = queue0.peek() + 1;
//                        queue1.offer(queue0.poll());
//                    }else{
//                        ans[i] = queue1.peek() + 1;
//                    }
//
//                }
//            }
//
//            for(int i = 0;i < ans.length;i++){
//                System.out.println(ans[i]);
//            }
//            s--;
//        }
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.get(1);    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.get(2);    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.get(1);    // 返回 -1 (未找到)
//        lRUCache.get(3);    // 返回 3
//        lRUCache.get(4);    // 返回 4

//        MyHashMap myHashMap = new MyHashMap();
//        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//        myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//        myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//        myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//        myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]


    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        if (n == 2) {//当绳子长度为2时，
            return 1;
        }
        if (n == 3) {//当绳子长度为3时
            return 2; // 1 + 2
        }

        //下面是绳子长度为4及4以上时，
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3; // 将绳子长度为3看成一个整体，初始化
        for (int k = 4; k <= n; k++) {
            for (int i = 1; i <= k / 2; i++) {
                dp[k] = Math.max(dp[k], dp[i] * dp[k - i]);
            }
        }
        return dp[n];
    }




    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int clo = grid[0].length;
        int[][] dp = new int[row][clo];
        int[][] dir = new int[row][clo];

        dp[0][0] = grid[0][0];
        for(int i = 1;i < row;i++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
            dir[i][0] = 2;
        }

        for(int j = 1;j < clo;j++){
            dp[0][j] = grid[0][j] + dp[0][j - 1];
            dir[0][j] = 1;
        }

        for(int i = 1;i < row;i++){
            for(int j = 1;j < clo;j++){
                if(dp[i - 1][j] >= dp[i][j - 1]){
                    dp[i][j] = dp[i][j - 1];
                    dir[i][j] = 1;
                }else{
                    dp[i][j] = dp[i - 1][j];
                    dir[i][j] = 2;
                }
                dp[i][j] += grid[i][j];
            }
        }
        List<Integer> path  = new ArrayList<>();
        help(grid,dir,path,row - 1,clo - 1);

        for(int i = 0;i < path.size();i++){
            System.out.print(path.get(i) + " ");
        }

        return dp[row - 1][clo - 1];
    }

    public static void help(int[][] grid,int[][] dir,List<Integer> path,int i,int j){
        if(i == 0 && j == 0) {
            path.add(grid[i][j]);
            return;
        }

        path.add(grid[i][j]);
        if(dir[i][j] == 1){
            help(grid, dir, path, i, j - 1);
        }else{
//            path.add(grid[i][j - 1]);
            help(grid, dir, path, i - 1, j);
        }
    }

}
