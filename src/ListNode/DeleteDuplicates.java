package ListNode;

import org.junit.Test;

public class DeleteDuplicates {
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
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        deleteDuplicates(head);
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-111);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else{
                cur =  cur.next;
            }
        }
        return head;
    }
}
