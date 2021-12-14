package SString;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5,7,7,8,8,8,10},6));
    }

    public static int search(int[] nums, int target) {
        int res = 1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                flag = true;
                if(nums[i] == nums[i+1]){
                    res ++;
                }
            }
        }
        if(!flag) res = 0;
        return res;
    }
}
