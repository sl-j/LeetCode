package Array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new  int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int num:nums) {
            System.out.print(num+" ");
        }
    }

    /**
     *双指针，right一直向后移动，当right指向非零元素时，和left交换元素，然后left++，否则，left不动（保证left左边全为非零。right找非零交换）
     */
//    public static void moveZeroes(int[] nums) {
//       int left,right,n;
//       left = 0;
//       right = 0;
//       n = nums.length;
//       while (right < n){
//           if(nums[right] != 0){//右指针遇到非零，交换，left++
//               int temp;
//               temp = nums[left];
//               nums[left] = nums[right];
//               nums[right] = temp;
//               left++;
//           }
//           right++;//right一直右移
//       }
    public static void moveZeroes(int[] nums){
        int notNull = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[notNull++] = nums[i];
            }
        }
        for(int i = notNull; i < nums.length;i++){
            nums[i] = 0;
        }
    }
}
