package TwoPointer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class MergeTwoLists {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        mergeTwoLists(l1,l2);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dum = res;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                dum.next = l1;
                l1 = l1.next;
            }else {
                dum.next = l2;
                l2 = l2.next;
            }
            dum = dum.next;
        }
        dum.next = l1 == null ? l2:l1;
        return res.next;
    }
}
