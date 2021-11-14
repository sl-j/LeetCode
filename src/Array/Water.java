package Array;


/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Water {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,1}));
    }

    //双指针思路，不断探寻边界，根据边界和x坐标求面积最大值
    public static int maxArea(int[] height) {
        int left,right,maxArea = 0,ans = 0;//left代表左边，right代表右边。如果将maxarea定义在循环中，会减少内存消耗
        left = 0;
        right = height.length-1;
        while(left < right){
            ans = Math.min(height[left],height[right]) * (right-left);//最短边决定水的高度，计算每一个最短边下的面积，得到最大值
            maxArea = Math.max(maxArea,ans);
            if(height[left]<height[right]){//计算完面积后，挪动最小边，寻找下一条最小边
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
