package DC;


public class ReverseList {

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
        reverseBetween(head,2,4);
    }
//    public static ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode curr = head;
//        while (curr != null){
//            ListNode next = curr.next;//单链表需要一个保存下一个结点
//            curr.next = pre;//翻转
//            pre = curr;//pre向后挪动
//            curr = next;//curr向后挪动
//        }
//        return pre;
//    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // 找到翻转链表部分的前一个节点, 1->2->3->4->5->NULL, m = 2, n = 4 指的是 节点值为1
        for (int i = 0; i < left - 1; i++) pre = pre.next;
        // 用双指针,进行链表翻转
        ListNode node = null;
        ListNode curr = pre.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = node;
            node = curr;
            curr = next;
        }
        pre.next.next = curr;
        pre.next = node;
        return dummy.next;
    }

}
