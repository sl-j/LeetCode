package one;

import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

class MyStack {

    Deque<Integer> queue1;
    Deque<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        while(!queue2.isEmpty()) queue1.offer(queue2.poll());
        while(queue1.size() > 1){
            queue2.offer(queue1.poll());
        }

        return queue1.poll();
    }
    
    public int top() {
        while(!queue2.isEmpty()) queue1.offer(queue2.poll());
        while(queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        int num = queue1.poll();
        queue2.offer(num);
        int[][] cache = new int[1][1];
        Arrays.fill(cache,-1);

        Deque<Integer> maxQueue = new LinkedList<>();


        return num;

    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
