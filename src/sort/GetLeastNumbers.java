package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class GetLeastNumbers {
    public static void main(String[] args) throws IOException {
//        getLeastNumbers(new int[]{3,2,1},2);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars1 = br.readLine().toLowerCase().toCharArray();
        char[] chars2 = br.readLine().toLowerCase().toCharArray();

        int count = 0;
        for(char ch : chars1){
            if(ch == chars2[0]) count++;
        }

        System.out.println(count);
    }
    /**
     * 会被嘲笑的解法
     */
//    public static int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        int[] priority = new int[k];
//        for (int i = 0; i < k; i++) {
//            priority[i] = arr[i];
//        }
//        return priority;
//    }

    /**
     * 优先队列，但是一样会被嘲笑的解法
     */
//    public static int[] getLeastNumbers(int[] arr, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        for (int i = 0; i < arr.length; i++) {
//            priorityQueue.offer(arr[i]);
//        }
//        int[] priority = new int[k];
//        for (int i = 0; i < k; i++) {
//            priority[i] = priorityQueue.poll();
//        }
//        return priority;
//    }

    /**
     * 大顶堆解法
     *
     */
//    public static int[] getLeastNumbers(int[] arr, int k) {
//        if(k > arr.length || k == 0) return new int[]{};
//        PriorityQueue<Integer> priority = new PriorityQueue<>((o1,o2) -> {
//                return o2 - o1;
//            }
//        );
//        for (int i = 0; i < k; i++) {
//            priority.offer(arr[i]);
//        }
//        for (int i = k; i < arr.length; i++) {
//            if(arr[i] < priority.peek()){
//                priority.poll();
//                priority.offer(arr[i]);
//            }
//        }
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = priority.poll();
//        }
//        return res;
//
//    }

    /**
     * 快排解法
     * @param arr
     * @param k
     * @return
     */
//    public static int[] getLeastNumbers(int[] arr, int k) {
//        if(arr == null || k == 0) return new int[0];
//        quickSort(arr,0,arr.length - 1);
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = arr[i];
//        }
//        return res;
//    }
//
//    public static void quickSort(int[] arr,int i,int j){
//        if(i >= j) return;
//        int left = i,right = j,tmp = arr[left];//将tmp作为哨兵
//        while (left < right){
//            while (left < right && arr[right] >= tmp) right--;//如果right指向的值大于等于哨兵，right左移
//            arr[left] = arr[right];
//            while (left < right && arr[left] <= tmp) left++;//如果left指向的值小于等于哨兵，left右移
//            arr[right] = arr[left];
//        }
//        arr[left] = tmp;
//        quickSort(arr,i,left - 1);
//        quickSort(arr,left + 1,j);
//    }

    /**
     * 快速选择算法
     */

    public static int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || k == 0) return new int[0];
        if(k >= arr.length) return arr;
        quickSearch(arr, 0, arr.length - 1, k );
        return Arrays.copyOf(arr, k);
//        return quickSort(arr,k,0, arr.length - 1);

    }

//    public static int[] quickSearch(int[] arr,int low,int high,int k){
////        if(i >= j) return;
//        int i = partition(arr, low, high);
//        if(i == k-1) return Arrays.copyOf(arr, k-1);
//        else return i > k ? quickSearch(arr,low,i - 1,k) : quickSearch(arr,i + 1,high,k);
//
//    }

    public static void quickSearch(int[] arr,int i,int j,int k){
        int left = i,right = j,tmp = arr[left];//将tmp作为哨兵
        while (left < right){
            while (left < right && arr[right] >= tmp) right--;//如果right指向的值大于等于哨兵，right左移
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) left++;//如果left指向的值小于等于哨兵，left右移
            arr[right] = arr[left];
//            swap(arr,left,right);
        }
        arr[left] = tmp;
        if(left < k)  quickSearch(arr, left + 1, j, k);
        if(left > k)  quickSearch(arr,i,left - 1,k);
        return;
    }

//    public static int[] getLeastNumbers(int[] arr, int k) {
//        if(arr == null || k == 0) return new int[0];
//        int[] counter = new int[10001];
//        int[] res = new int[k];
//        for (int num:arr) {
//            counter[num]++;
//        }
//        int idx = 0;
//        for (int i = 0; i < counter.length; i++) {
//            while (counter[i]-- > 0 && idx < k){
//                res[idx++] = i;
//            }
//            if(idx == k) break;
//        }
//        return res;
//    }
}
