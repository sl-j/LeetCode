package one;

import org.junit.Test;

import java.util.*;

public class MinSwaps {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,0,0};
//        System.out.println(minSwaps(nums));
//        List<Integer> intersection = intersection(new int[][]{{7,34,45,10,12,27,13},{27,21,45,10,12,13}});
//        System.out.println(intersection);
//        int[] ints = countRectangles(new int[][]{{7,1},{2,6},{1,4},{5,2},{10,3},{2,4},{5,9}}, new int[][]
//                {{10,3},{8,10},{2,3},{5,4},{8,5},{7,10},{6,6},{3,6}});
//        String s1 = "123";
//        String s2 = "321";
//        System.out.println(s1.compareTo(s2));
//        Map<Integer,Integer> map = new HashMap<>();
        validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});


    }

//    public static int minSwaps(int[] nums) {
//        if(nums.length == 1 || nums.length == 0) return 0;
//        int res = Integer.MAX_VALUE;
//        int oneCnt = 0;
//        int zeroCnt = 0;
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if(nums[i] == 1) oneCnt++;
//        }
//        for (int i = 0; i < oneCnt; i++) {
//            if(nums[i] == 0) zeroCnt++;
//        }
//        for (int i = 1; i < n + oneCnt; i++) {
//            if(nums[(i - 1) % n] == 0) zeroCnt--;//出窗口为0则减1
//            if(nums[(i + oneCnt - 1) % n] == 0) zeroCnt++;//入窗口为0，则加1
//            res = Math.min(zeroCnt,res);
//        }
//        return res;
//    }

    public static List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[1005];
        int row = nums.length;
        for(int[] tmp : nums){
           for(int num : tmp){
               count[num]++;
               if(count[num] == row) ans.add(num);
           }
        }
        Collections.sort(ans,(o1,o2) -> o1 - o2);

        return ans;
    }

    public static int[] countRectangles(int[][] rectangles, int[][] points) {
//        Arrays.sort(points,(int[] o1,int[] o2) ->{
//            if(o1[0] == o2[0]) return o1[1] - o2[1];
//            else return o1[0] - o2[0];
//        });
//
        System.out.println();
        int n = rectangles.length;;
        int[] first = new int[n];
        int[] second = new int[n];

        for(int i = 0;i < n;i++){
            first[i] = rectangles[i][0];
            second[i] = rectangles[i][1];
        }
        
        int[] ans = new int[points.length];

        for(int i = 0;i < ans.length;i++){
            for(int j = 0;j < n;j++){
                if(points[i][0] <= rectangles[j][0] && points[i][1] <= rectangles[j][1]) ans[i]++;
            }
        }
        return ans;
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        int n = 0;
        int m = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(n < pushed.length){
            if(n < pushed.length) stack.push(pushed[n++]);
            while(m < popped.length && stack.peek() != null && stack.peek() == popped[m] ){
                stack.pop();
                m++;
            }
        }
        while(m < popped.length){
            if(stack.peek() != popped[m++] ) return false;
            stack.pop();

        }


        return stack.isEmpty();
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ans = nums[0];
        int end = 0;
        for(int i = 1;i < nums.length;i++){
            sum = Math.max(sum + nums[i],nums[i]);
            if(ans < sum){
                end = i;
                ans = sum;
            }
        }

        int tmp = ans;
        List<Integer> res = new ArrayList<>();
        for(int i = end;tmp != 0;i--){
            res.add(0,nums[i]);
            tmp -= nums[i];
        }
        int[] t = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            t[i] = res.get(i);
        }

        for(int num : t){
            System.out.print(num + " ");
        }


        return ans;
    }

    @Test
    public void test(){
        mySqrt(8);
    }

    private final static float mod = (float) 1e-3;
    public float mySqrt(int x) {
        float left = 0,right = x;
        while(left <= right){
            float mid = left + (right - left) / 2;
            if(x / mid >= mid){
                left = mid + mod;
            }else{
                right = mid - mod;
            }
        }

        return right;
    }




}
