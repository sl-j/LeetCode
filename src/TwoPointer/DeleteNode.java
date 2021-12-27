package TwoPointer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class DeleteNode {


    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        deleteNode(head,5);
    }

//    public static ListNode deleteNode(ListNode head, int val) {
//        ListNode headPointer = new ListNode(0);//创建头指针
//        headPointer.next = head;
//        ListNode pre = headPointer;//pre指针指向前一个结点，node指向当前结点
//        ListNode node = head;
//        while (node != null){
//            if(node.val == val){//相等时，前驱节点的指针直接指向当前指针的下一个结点
//                pre.next= node.next;
//                return headPointer.next;
//            }
//            pre = pre.next;
//            node = node.next;
//        }
//        return headPointer.next;
//    }

    //一直遍历，遍历到当前结点的值为目标值，然后停止遍历，直接将pre的指针指向当前结点的下一个结点
    public static ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null && curr.val != val){
            pre = pre.next;
            curr = curr.next;
        }
        pre.next = curr.next;
        return head;
}
}
