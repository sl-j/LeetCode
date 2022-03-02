package dp;

import org.junit.Test;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 */
public class Trap {

    @Test
    public void test(){
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }

    /**
     * 普通方法，此处能存储多少水，取决于左边最高点和右边最高点的最小值
     * @param height
     * @return
     */
//    public int trap(int[] height) {
//        int len = height.length;
//        int ans = 0;
//        for (int i = 0; i < len; i++) {
//            int leftMax = 0;
//            int rightMax = 0;
//            for (int j = i; j >= 0; j--) {
//                leftMax = Math.max(height[j],leftMax);
//            }
//            for (int j = i; j < len; j++) {
//                rightMax = Math.max(height[j],rightMax);
//            }
//
//            ans = ans + Math.min(leftMax,rightMax) - height[i];
//        }
//
//        return ans;
//    }
//

    /**
     * 提前存储每个点上，左边最大值和右边最大值的最小值
     * @param height
     * @return
     */
//    public int trap(int[] height) {
//        int ans = 0;
//        int len = height.length;
//        int[] leftMax = new int[len];
//        int[] rightMax = new int[len];
//        leftMax[0] = height[0];
//        for (int i = 1; i < len; i++) {
//            leftMax[i] = Math.max(height[i],leftMax[i - 1]);
//        }
//        rightMax[len - 1] = height[len - 1];
//        for (int i = len - 2; i >= 0 ; i--) {
//            rightMax[i] = Math.max(rightMax[i + 1],height[i]);
//        }
//
//        for (int i = 0; i < len; i++) {
//            ans = ans + Math.min(leftMax[i],rightMax[i]) - height[i];
//        }
//        return ans;
//    }

    /**
     * 双指针解法：若左边比右边高，以左边为边界，在右边查找（若右指针指向的高度小于右边最大的高度，证明有低洼，加入答案）
     *           若右边比左边高，以右边为边界，接下来的步骤同理
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0,rightMax = 0;
        while (left < right){
            while (height[left] <= height[right] && left < right){
                if(height[left] > leftMax) leftMax = height[left];
                else ans = ans + (leftMax - height[left]);
                left++;
            }
            while (height[right] <= height[left] && left < right){
                if(height[right] > rightMax) rightMax = height[right];
                else ans = ans + (rightMax - height[right]);
                right--;
            }
        }
        return ans;
    }
}
