package sort;

public class test {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;
        while (true){
            int index = partition(nums, left, right);
            if(index == target) return nums[index];
            else if(index < target) left = index + 1;
            else right = index - 1;
        }
    }

    public static int partition(int[] nums,int left,int right){
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            while (nums[j] >= pivot && i < j){
                j--;
            };
            nums[i] = nums[j];
            while (nums[i] <= pivot && i < j){
                i++;
            };
            nums[j] = nums[i];
            if(i >= j) break;
        }
        nums[j] = pivot;
        return j;
    }

    public static void swap(int[] nums,int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
