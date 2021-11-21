package Array;

import java.util.Arrays;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        rotate(nums,2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);

        }
    }
//开辟新的数组空间
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        int[] temp = new int[n];
//        for (int i = 0; i < n; i++) {
//           temp[(i + k)%n] = nums[i];
//        }
//        System.arraycopy(temp,0,nums,0,n);
//    }
    //数组翻转
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,k,nums.length - 1);
        reverse(nums,0,k - 1);
    }
    public static void reverse(int[] nums,int start,int end){
        int temp;
        while (start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i]);
//        }
//        System.out.println();
    }
}
