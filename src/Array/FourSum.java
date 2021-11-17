package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5},-11));
    }


    //先固定两个指针，再移动双指针
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<4){//长度小于4时，证明无解
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-3;i++){//右边有三个指针
            if(i > 0&&nums[i] == nums[i-1]){//去重
                 continue;
            }
            for(int j = i+1;j<nums.length-2;j++){//左边第二个指针
                if(j > i+1&&nums[j] == nums[j-1]){//去重,j=i+1时，[2,2,2,2,2]无法通过，防止有重复导致无限continue的情况
                    continue;
                }
                int left,right;
                left = j+1;
                right = nums.length-1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while (left<right&&nums[left]==nums[left+1]) left++;//去重
                        while (left<right&&nums[right]==nums[right-1]) right--;//去重
                        left++;right--;
                    }else if(sum < target) {
                        left++;
                    }else {
                        right--;
                    }
                }
                }
            }
        return res;

    }
}
