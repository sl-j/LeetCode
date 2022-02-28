package ListNode;

import org.junit.Test;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    @Test
    public void test(){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode listNode = mergeKLists(new ListNode[]{});

    }
    //优先队列的方法
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length == 0) return null;
//
//        ListNode dummy = new ListNode();
//        ListNode ans = dummy;
//
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//
//        for (ListNode node: lists) {
//            if(node == null) continue;
//            queue.offer(node);
//        }
//
//        while (queue.size() != 0){
//            ListNode tmp= queue.poll();
//            ans.next = tmp;
//            ans = ans.next;
//            if(tmp.next != null){
//                queue.offer(tmp.next);
//            }
//        }
//
//        return dummy.next;
//    }

    //分治
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists,int l,int r){
          if(l == r) return lists[l];
          if(l > r) return null;
          int mid = r + (l - r) / 2;
          return mergeTwoLists(merge(lists,l,mid - 1),merge(lists, mid, r));
    }

    //合并两个链表
    public ListNode mergeTwoLists(ListNode A,ListNode B){
          if(A == null || B == null ){
              return A != null ? A : B;
          }

          ListNode ans = new ListNode();
          ListNode tmp = ans;
          ListNode headA = A;
          ListNode headB = B;
          while (headA != null && headB != null){
              if(headA.val <= headB.val){
                  tmp.next = headA;
                  headA = headA.next;
              }else {
                  tmp.next = headB;
                  headB = headB.next;
              }
              tmp = tmp.next;
          }

          tmp.next = (headA != null ? headA : headB);
          return ans.next;
    }
}
