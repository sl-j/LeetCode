package first;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,5,6},2));
    }

    //简单的二分查找
    public static int search(int[] nums, int target) {
        int left,right,mid,sum=0;
        left = 0;
        right = nums.length-1;
//        mid = (right - left)/2 + left;
        while (left <= right){
            mid = (right - left)/2 + left;//防止数值越界
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            }
        return left;
        }

}
