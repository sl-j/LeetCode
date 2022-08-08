package sort;


import DC.BuildTree;

import java.util.*;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next  = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next= new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode tmp = new ListNode();
        tmp = res;
        int t = 0,num1,num2;
        int sum = 0;
        while (l1 != null || l2!=null){
            num1 = l1 == null ? 0 : l1.val;
            num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + t;
            t = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if( t == 1){
            tmp.next = new ListNode(t);
        }

        return res.next;
    }

    public int canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals,(int[] o1,int[] o2) -> o1[1] - o2[1]);

        PriorityQueue<Integer> quque = new PriorityQueue<Integer>();

        quque.add(intervals[0][1]);


        for(int i = 1;i < intervals.length;i++){
            int cur = intervals[i][0];
            while(!quque.isEmpty() && cur >= quque.peek()){
                quque.poll();
            }
            quque.offer(intervals[i][1]);
        }

        return quque.size();
    }
}
