package ds;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class MaxSubArray {
    public static void main(String[] args) {

    }

    //动态规划
    public static int maxSubArray(int[] nums) {
        int pre = 0, cur = nums[0];
        for (int x :nums) {
            pre = Math.max(pre + x ,x);//加上当前值之后，和当前值进行比较，判断是否为最大值
            cur = Math.max(pre,cur);//得到的最大值，和前面计算的最大值比较
        }
        return cur;
    }
}
