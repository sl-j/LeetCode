package ListNode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DetectCycle {

      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    @Test
    public void test(){
          ListNode head = new ListNode(3);
          head.next = new ListNode(2);
          head.next.next = new ListNode(0);
          head.next.next.next = new ListNode(4);
          head.next.next.next.next = head.next;
          detectCycle(head);
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        boolean isCycle = false;

        while (true){
            if(fast == null || fast.next == null) {
                break;
            }
            else {
                fast = fast.next.next;
                slow = slow.next;
            }
            if(fast == slow) {
                isCycle = true;
                break;
            }
        }

        if(!isCycle) return null;

        fast = head;
        while ( fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
