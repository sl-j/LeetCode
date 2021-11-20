package Array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
    /**
     *    快慢指针：将快指针的值赋给慢指针,此方法并不是实际的删除，而是得到不一样的数字数量
     */
    public static int removeDuplicates(int[] nums) {
        if(nums == null){//数组为空
            return 0;
        }
        int n = nums.length;
        int fast = 1; //数组第一个元素必留，所以fast和slow都为1
        int slow = 1;
        while (fast < n){//结束
            if(nums[fast]!=nums[fast-1]){//此时，证明非重复数字
                nums[slow++] = nums[fast];//将非重复数字给slow，slow指针前移
            }
            fast++;//无论是否有重复数据，fast都要++
        }
        return slow;

    }
}
