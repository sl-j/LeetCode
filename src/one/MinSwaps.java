package one;

public class MinSwaps {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,0};
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int[] nums) {
        if(nums.length == 1 || nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int oneCnt = 0;
        int zeroCnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1) oneCnt++;
        }
        for (int i = 0; i < oneCnt; i++) {
            if(nums[i] == 0) zeroCnt++;
        }
        for (int i = 1; i < n + oneCnt; i++) {
            if(nums[(i - 1) % n] == 0) zeroCnt--;//出窗口为0则减1
            if(nums[(i + oneCnt - 1) % n] == 0) zeroCnt++;//入窗口为0，则加1
            res = Math.min(zeroCnt,res);
        }
        return res;
    }
}
