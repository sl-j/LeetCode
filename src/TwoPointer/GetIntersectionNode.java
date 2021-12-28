package TwoPointer;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class GetIntersectionNode {
     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

      public static void main(String[] args) {

      }

         /**
          * 错的人一定会错过,对的人终究会重逢.
          * A和B的公共部分长度为z，A和B除去非公共部分长度为x和y
          * 让A和B都走x+y+z的路程，开始时一个链表的长度为领先若干，但是再从另一个链表开始遍历时，长度又会减去若干，最终会同步
          * @param headA
          * @param headB
          * @return
          */
      public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode A = headA;
            ListNode B = headB;
            while (A != B){//当a和b相等时时，证明相遇
                A = (A != null) ? A.next : headB;//a链表走完，就去走b链表
                B = (B != null) ? B.next : headA;//b链表走完，就去走b链表
            }
            return A;
        }
         }
}
