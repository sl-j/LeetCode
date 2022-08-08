package lru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class list {

      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        ListNode head = new ListNode(Integer.parseInt(str[0]));
        ListNode cur = head;
        for(int i = 1;i < str.length;i++){
            cur.next = new ListNode(Integer.parseInt(str[i]));
            cur = cur.next;
        }

        System.out.println(head);
//        TreeNode root = deserialize(str);

    }




}
