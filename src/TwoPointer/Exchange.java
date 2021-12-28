package TwoPointer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Exchange {
    public static void main(String[] args) {
        exchange(new int[]{1,2,3,4});
    }

//    public static int[] exchange(int[] nums) {
//        int left = 0,right = nums.length - 1,tmp;
//        while (left < right){
//            while ( left < right && (nums[left] % 2 == 1)) left++;
//            while ( left < right && (nums[right] % 2 == 0)) right--;
//            tmp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = tmp;
//        }
//        return nums;
//    }

    /**
     * 快慢指针的方法，fast指向奇数，slow指向下一个奇数要存放的位置
     * @param nums
     * @return
     */
    public  static int[] exchange(int[] nums){
        int fast = 0,slow = 0,tmp;
        while (fast < nums.length){
            if(nums[fast] % 2 == 1){
                tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
