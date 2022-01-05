package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> A,B;
    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>();//小顶堆，维护大的数值
        B = new PriorityQueue<>(Comparator.reverseOrder());//大顶堆，维护小的数值
    }

    public void addNum(int num) {
        if(A.size() == B.size()){
            B.offer(num);//维护B的大顶堆
            A.offer(B.poll());//
            /**
             *取出B的堆顶元素，然后放入A中，维护A的小顶堆，保证A始终等于B，或者A比B多一个数值
             * 这样可以保证偶数时，A+B的堆顶元素除以2为中位数，奇数时A的堆顶元素为中位数
              */
        }
        if(A.size() != B.size()){
            A.offer(num);
            B.offer(A.poll());
        }

    }

    public double findMedian() {
      return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : A.peek();
    }
}
