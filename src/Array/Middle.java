package Array;

import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Middle {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

    }

    /**
     * 将两个数组合并、排序，再求中位数
     *   暴力求解，时间复杂度不符合要求
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,nums,0,nums1.length); //将nums1合并到nums中
        System.arraycopy(nums2,0,nums,nums1.length,nums2.length);//将nums2合并到nums中
        Arrays.sort(nums); //内部排序
        double mid = 0;
        if(nums.length%2 != 0){ //奇数时，直接取数组中间值
            mid = nums[nums.length/2];
        }else {
            mid = (nums[nums.length/2] + nums[nums.length/2 - 1])/2.0; //偶数时，取中间下标和中间下标-1的值
        }

        return mid;
    }

//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            int[] temp = nums1;
//            nums1 = nums2;
//            nums2 = temp;
//        }
//
//        int m = nums1.length;
//        int n = nums2.length;
//
//        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
//        int totalLeft = (m + n + 1) / 2;
//
//        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
//        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
//        int left = 0;
//        int right = m;
//
//        while (left < right) {
//            int i = left + (right - left + 1) / 2;
//            int j = totalLeft - i;
//            if (nums1[i - 1] > nums2[j]) {
//                // 下一轮搜索的区间 [left, i - 1]
//                right = i - 1;
//            } else {
//                // 下一轮搜索的区间 [i, right]
//                left = i;
//            }
//        }
//
//        int i = left;
//        int j = totalLeft - i;
//
//        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
//        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
//        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
//        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
//
//        if (((m + n) % 2) == 1) {
//            return Math.max(nums1LeftMax, nums2LeftMax);
//        } else {
//            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
//        }
//    }

}
