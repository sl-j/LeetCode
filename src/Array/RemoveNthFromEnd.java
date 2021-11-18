package Array;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        System.out.println(removeNthFromEnd(head,2));
    }

    //快慢指针
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0,head);//哑节点。指向头结点，防止链表全为null，不需要判断头结点是否为空
        ListNode fast = head;
        ListNode slow = dummy;//快指针指向头节点,慢指针指向哑节点
        for (int i = 0; i < n; i++) {//快指针向前移动n位
            fast = fast.next;
        }
        while (fast!=null){//快指针指向结尾时,slow刚好指向需要删除结点的前驱结点
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;//删除结点
        ListNode res = dummy.next;
        return res;
    }
}
