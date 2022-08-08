package tests;

import java.time.LocalDate;
import java.util.*;

class LargestLessThanK {

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 9};
        LargestLessThanK demo = new LargestLessThanK();
        System.out.println(demo.largestLessThanK(nums, 5458));
    }

    int k, num = 0, len, max = 0; // 假定给定的k为正数，无法组成比k小的数时返回0
    int[] nums;

    public int largestLessThanK(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        this.len = Integer.toString(k).length(); // 取得k的位数
        Arrays.sort(nums);
        backtrack(0);
        return max;
    }

    private void backtrack(int depth) {
        if (depth == len) return; // 剪枝：最大层深
        for (int i = 0; i < nums.length; i++) {
            num = num * 10 + nums[i];
            if (num > k) { // 剪枝：返回上层
                num = (num - nums[i]) / 10;
                return;
            }
            if (num > max) max = num;
            backtrack(depth + 1);
            num = (num - nums[i]) / 10; // 撤销
        }
    }


    public int findMinArrowShots(int[][] points) {

        int res = 1;
        int pre = points[0][1];

        for(int i = 1;i < points.length;i++){
            if(points[i][0] > pre){
                pre = points[i][1];
                res++;
            }
        }

        return res;
    }

    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<int[]> queue = new PriorityQueue<>();
        int len = arr.length;
        int[] ans = new int[len];

        for(int i = 0;i < len;i++){
            int[] tmp = new int[]{arr[i],i};
            queue.offer(tmp);
        }

        int pre = queue.peek()[0];
        int index = 1;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            ans[tmp[1]] = index;
            if(pre != tmp[0]){
                pre = tmp[0];
                index++;
            }
        }

        return ans;
    }
}