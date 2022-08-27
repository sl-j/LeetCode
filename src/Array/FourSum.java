package Array;


import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class FourSum {
    public static void main(String[] args) {
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1 - x) == Math.abs(o2 - x)) return o2 - o1;
                else return Math.abs(o2 - x) - Math.abs(o1 - x);
        });



        for(int num : arr){
            queue.offer(num);
            if(queue.size() > k) queue.poll();
        }

        while(!queue.isEmpty()){
            res.add(queue.poll());
        }

        return res;
    }

}
