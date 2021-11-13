package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoNumber {
    public static void main(String[] args) {
        /**给定一个整数数组 num和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。

         你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

         你可以按任意顺序返回答案

         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/two-sum
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         *
         */
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toString();
        String[] arr = str.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        int target;
        target = sc.nextInt();
        int[] results = new int[2];

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
               if(map.containsKey(target-nums[i])){
                   results[0] = map.get(target - nums[i]);
                   results[1] = i;
                   System.out.println(results[0]+" "+results[1]);
               }
               map.put(nums[i],i);
        }





    }
}
