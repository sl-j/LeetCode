import org.junit.Test;

import java.util.Random;

public class t2 {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    @Test
    public void test(){
//        int kthLargest = findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 2);
//        System.out.println(kthLargest);
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        boolean palindrome = isPalindrome(head);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums,0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums,int left,int right){
        if(left < right){
            int index = partition(nums,left,right);
            quickSort(nums,left + 1,right);
            quickSort(nums,left,right - 1);
        }
    }

    public int partition(int[] nums,int left,int right) {

        Random random = new Random();
        int ran = left + random.nextInt(right - left + 1);

        swap(nums, left, ran);
        int pivot = nums[left];
        int index = left;
        for (int i = index + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                index++;
                swap(nums, index, i);
            }
            swap(nums, index, left);
        }
        return index;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        ListNode node = reverse(tmp);

        slow.next = node;

        ListNode left = head;
        ListNode right = node;

        while(right != null){
            if(left.val == right.val){
                left = left.next;
                right = right.next;
            }else{
                return false;
            }
        }

        ListNode reverse = reverse(node);
        slow.next = reverse;

        StringBuilder sb = new StringBuilder();


        return true;
    }


    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
