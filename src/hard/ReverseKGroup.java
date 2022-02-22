package hard;

public class ReverseKGroup {

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
        reverseKGroup(head,4);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;//记录翻转链表组的前驱结点
        ListNode follow;//记录翻转链表组的下一个结点
        ListNode start = pre.next;//记录翻转链表组的第一个节点
        ListNode end = pre.next;//记录翻转链表组的最后一个结点
        while (end != null){
            for (int i = 0; i < k - 1 && end != null; i++) {//向后移动指针
                end = end.next;
            }

            if(end == null) break;

            follow = end.next;
            end.next = null;//设置为null，方便下面的翻转

            reverse(start);//翻转之后start和end的位置颠倒

            pre.next = end;//前驱指向颠倒后的end
            pre = start;//重新定义pre的位置
            start.next = follow;//start此时在最后，后继指向follow

            //此处是重新将star和end指向链表组的起始位置
            start = follow;//start指向follow
            end = follow;//end也指向follow
        }
        return dummy.next;

    }

    public static void reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }
}
