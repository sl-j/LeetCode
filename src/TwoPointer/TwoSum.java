package TwoPointer;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可
 */
public class TwoSum {

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9);
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0,right = nums.length - 1,sum;
        while (left < right){
            if(target - nums[left] == nums[right]) return new int[]{nums[left],nums[right]};
            else if(target - nums[left] > nums[right]) left++;
            else right--;

        }
        return new int[]{};
    }
}
