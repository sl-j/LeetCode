package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Three {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        Iterator it = lists.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    //三指针思路(固定一个数，在固定位置之后搜寻另外两个数)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){//数组长度小于3或者空，则无解
            return answers;
        }
        Arrays.sort(nums);
        int left,right,sum;
       for(int i = 0;i < nums.length;i++){
           if(nums[i]>0){//排序后，若nums[i]>0则后续不可能为负数
               break;
           }
           if(i > 0 && nums[i] == nums[i-1]){//固定指针去重，i=0时判断会越界
               continue;
           }
           left = i+1;
           right = nums.length-1;
           while (left < right){//挪动指针，遍历i右边的数组
               sum = nums[i] + nums[left] + nums[right];
               if(sum == 0){
                   ArrayList<Integer> list = new ArrayList<Integer>();
                   list.add(nums[i]);
                   list.add(nums[left]);
                   list.add(nums[right]);
                   answers.add(list);
                   while(left < right&&nums[left] == nums[left+1]){left++;}//如果有重复数值，进入此循环，达到去重的效果;left<right是为了满足外部的条件限制，且保证不会越界
                   while(left < right&& nums[right] == nums[right-1]){right--;}//如果有重复数值，进入此循环，达到去重的效果
                   left++;
                   right--;//要先去重，再自加和自减，否则会有两个重复，如2，2
               }else if(sum<0){ //sum小于0，left右移
                   left++;
               }else {//sum大于0，right右移
                   right--;
               }
           }
           }

        return answers;
    }
}
