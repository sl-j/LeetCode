package ListNode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    @Test
    public void test(){
          ListNode head= new ListNode(1);
          head.next = new ListNode(2);
          head.next.next = new ListNode(3);
          head.next.next.next = new ListNode(4);
          head.next.next.next.next = new ListNode(5);
          reorderList(head);
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;

        ListNode mid = findMid(head);
        ListNode cur = mid.next;
        mid.next = null;

        ListNode l1 = head;
        ListNode l2 = reverseList(cur);

        mergeList(head,l2);

    }


    //寻找中点，fast到达终点时，slow刚好走了fast的一半，即中点
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    //翻转链表
    public ListNode reverseList(ListNode cur){
        ListNode pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    //合并两个链表
    public void mergeList(ListNode l1,ListNode l2){
        ListNode tmpA;
        ListNode tmpB;
        while(l1 != null && l2 != null){
            tmpA = l1.next;
            tmpB = l2.next;

            l1.next = l2;
            l1 = tmpA;

            l2.next = l1;
            l2 = tmpB;
        }
    }
}
