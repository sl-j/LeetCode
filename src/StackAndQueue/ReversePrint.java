package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class ReversePrint {
    public static class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        int[] res = reversePrint(head);
        for (int i:
            res ) {
            System.out.print(i+" ");
        }

    }

    public static int[] reversePrint(ListNode head) {
        ListNode current = head;
        int[] res;
        int len = 0,i=0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current!=null){
            len++;
            stack.push(current.val);
            current = current.next;
        }
        res = new int[len];
        while (stack.peek()!=null){
            res[i++] = stack.pop();
        }
        return res;
    }
}
