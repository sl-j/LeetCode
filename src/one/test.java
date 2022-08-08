package one;

import java.util.Deque;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        stack.pop();
        stack.empty();

        Deque<Integer> queue = new LinkedList<>();
    }
}
