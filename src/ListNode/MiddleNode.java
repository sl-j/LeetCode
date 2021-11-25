package ListNode;

public class MiddleNode {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        middleNode(head);
    }

//    public static ListNode middleNode(ListNode head) {
//        int n = 0;//记录链表长度
//        ListNode cur = head;
//        while (cur != null){
//            n++;
//            cur = cur.next;
//        }
//        int k = 0;//寻找中间结点
//        cur = head;
//        while (k < n/2){
//            k++;
//            cur = cur.next;
//        }
//        return cur;
//
//    }

    //快慢指针(属实没想到),slow走一步，fast走两步，fast永远是slow的一倍
    public static ListNode middleNode(ListNode head){
        ListNode slow,fast;
        slow = head;
        fast = head;
        while (fast != null&&fast.next != null){//：当快指针正好指向链表尾部时，无法再移动两位；fast!=null):再移动两位，刚好指向链表的尾部下一个空结点
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
