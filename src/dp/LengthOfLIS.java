package dp;

import org.junit.Test;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS {

    @Test
    public void test(){
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }

    /**
     * 单纯的动态规划，dp[i]代表以i这个位置为结尾的最长递增子序列的长度
     * 计算dp[i]时，会和前面所有的dp进行比较，如果当前值大于前面某一个位置的值，考虑加入这个子序列中
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
       dp[0] = 1;
       int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;//在这一处，肯定序列为1
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            ans = Math.max(dp[i],ans);
        }
        int[] lis = getLIS(nums, dp);
        return ans;
    }

    /**
     * 此函数的作用是寻找路径
     * @param nums
     * @param dp
     * @return
     */
    public int[] getLIS(int[] nums,int[] dp){
        int maxLenIndex = 0;//记录在哪一个下标处找到最长子序列
        int len = 0;//记录子序列的长度
        //在dp数组中,找到最长的长度，和对应的下标
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > len){
                maxLenIndex = i;
                len = dp[i];
            }
        }

        int[] ans = new int[len];
        ans[--len] = nums[maxLenIndex];
        for (int i = maxLenIndex; i >= 0; i--) {
            if(nums[i] < nums[maxLenIndex] && dp[i] == dp[maxLenIndex] - 1){
                maxLenIndex = i;//更新下标
                ans[--len] = nums[i];
            }
        }
        return ans;
    }

    /**
     * dp加上二分查找
     * dp中存储的是nums中的数值
     * @param nums
     * @return
     */
//    public int lengthOfLIS(int[] nums) {
//       int[] dp = new int[nums.length];
//       int ans = 0;//ans表示的是dp存入数字的数量
//       dp[0] = nums[0];
//        for (int num : nums) {
//            int left = 0;
//            int right = ans;
//            int mid = 0;
//            while (left < right){
//                mid = left + (right - left) / 2;
//                if(dp[mid] < num) left = mid + 1;
//                else right = mid;
//            }
//            dp[left] = num;//最终left right都会指向一个地方,mid不会
//
//            if(ans == left) ans++;//如果left指向最右边，表示有新的数字加入，则最长子序列长度+1，数字范围+1
//        }
//        return ans;
//    }
}
