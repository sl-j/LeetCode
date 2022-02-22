package ListNode;

public class MergeTwoLists {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode dummy = new ListNode();
//        ListNode pre = dummy;//设置前驱结点
//        while (list1 != null && list2 != null){
//            if(list1.val <= list2.val){
//                pre.next = list1;
//                list1 = list1.next;
//            }else {
//                pre.next = list2;
//                list2 = list2.next;
//            }
//            pre = pre.next;
//        }
//        pre.next = list1 != null ? list1 : list2;
//        return dummy.next;
//    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        else if(list2 == null) return list1;
        else if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list2.next,list1);
            return list2;
        }
    }
}
