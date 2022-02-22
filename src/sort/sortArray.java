package sort;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 */
public class sortArray {

    public static void main(String[] args) {
        sortArray(new int[]{5,1,1,2,0,0});
    }

    public static int[] sortArray(int[] nums) {
        return quickSort(nums,0, nums.length - 1);

    }

    public static int[] quickSort(int[] nums,int left,int right){
        if(left >= right) return null;
        int i = left,j = right;
        int pivot = nums[left];
        while (i < j){
            while (nums[j] >= pivot && i < j) j--;
            while (nums[i] <= pivot && i < j) i++;
            swap(nums,i,j);
        }
        swap(nums,i,left);

        quickSort(nums,left,i - 1);
        quickSort(nums,i + 1,right);
        return nums;
    }

    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
