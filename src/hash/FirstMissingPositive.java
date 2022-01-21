package hash;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    /**
     * 先将小于0的数全部置为0，若有最小正数，则有两种情况，第一种，数组内的数值为1 - n-1，这时最小的正整数为n
     * 第二种情况，数组内的数值超出了数组的长度范围，这时最小正数肯定在[1,n-1]之内，
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] < 1) nums[i] = n + 1;//将小于1的数，全部置为0
        }

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if(index < n + 1){
                nums[index - 1] = -Math.abs(nums[index - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) return i + 1;
        }
        return n + 1;
    }

}
