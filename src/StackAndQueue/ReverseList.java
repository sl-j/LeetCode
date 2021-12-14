package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class ReverseList {

     public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
         ListNode head = new ListNode(1);
         head.next = new ListNode(2);
         head.next.next = new ListNode(3);
         head.next.next.next= new ListNode(4);
         reverseList1(head);

    }
    //迭代
    public static ListNode reverseList(ListNode head) {
       ListNode pre = null;
       ListNode current = head;
       while (current!=null){
           ListNode next = current.next;//执行下一句代码的next操作时，会失去接下来的地址，所以需要先存储下来
           current.next = pre;//反转的代码
           pre = current;//pre指向current，接下来current要后移
           current = next;
       }
       return pre;
    }
    //递归
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {//head为空，防止空链表，直接返回
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;//返回途中的动作，反转
        head.next = null;//断掉联系
        return newHead;
    }
}
