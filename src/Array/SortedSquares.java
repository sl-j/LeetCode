package Array;

import java.util.Arrays;

/**
 * 你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] result = sortedSquares(new int[]{-7,-3,2,3,11});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }

    }
    //暴力破解
//    public static int[] sortedSquares(int[] nums) {
//        for(int i = 0;i < nums.length;i++){
//            nums[i] *= nums[i];
//        }
//        Arrays.sort(nums);
//        return nums;
//    }
    //归并排序(输入为非降序，可以挨个对比两边的值，最大值一定在两边,需要开辟新的数组，时间复杂度比较低)
    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = nums.length - 1;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j){
            if(nums[i] * nums[i] < nums[j] * nums[j]){//两个边界指针，取相对大值
                ans[pos--] = nums[j] * nums[j];
                j--;
            }else {
                ans[pos--] = nums[i] * nums[i];
                i++;
            }
        }
        return ans;
    }
}
