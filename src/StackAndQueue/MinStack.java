package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> s1,s2;//s2存放s1的非严格降序元素，当s1出栈时，判断是否为s2的栈顶元素。保证s2的栈顶元素始终为s1中的最小值

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new LinkedList<Integer>();
        s2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty()||s2.peek()<=x){
            s2.push(x);
        }
    }

    public void pop() {
        if(s1.pop().equals(s2.peek())){
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
