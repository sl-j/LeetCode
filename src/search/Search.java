package search;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1},1));
    }
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return  0;
        }
       return binarySearch(nums, target) - binarySearch(nums,target - 1);
    }

    public static int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
