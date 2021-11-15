package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,0,1,1,55},3));
    }


    //依旧三指针的思路
    public static int threeSumClosest(int[] nums, int target) {
        int sum,left,right,p,ans = 0,m = Integer.MAX_VALUE;//m为上一次结果的值，p为三数之和与target的距离
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            left = i+1;
            right = nums.length-1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }
                if(sum < target){//三数之和小于target，left指针向右移动
                    while (left < right && nums[left] == nums[left+1]){left++;}//去重,必须去重在前,否则左右指针可能对于相同的数直接跳过
                    left++;

                }else {  //三数之和大于target,right指针向左移
                    while (left < right && nums[right] == nums[right-1]){right--;}
                    right--;

                }
                p = Math.abs(target-sum);//计算三数之和与target的距离
                if( p < m ){//更新距离，并记录sum
                    m = p;
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
