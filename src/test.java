import org.junit.Test;

import java.util.*;

public class test {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

   @Test
   public void test(){

          ListNode head = new ListNode(1);
          head.next = new ListNode(2);
       head.next.next = new ListNode(3);
       head.next.next.next = new ListNode(4);
       head.next.next.next.next = new ListNode(5);

       reverseBetween(head,2,4);

   }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode preNode = null;
        ListNode cur = pre.next;

        for (int i = left; i <= right; i++) {
            ListNode tmp = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = tmp;
        }
        pre.next.next = cur;
        pre.next = preNode;

        return dummy.next;

    }

}
