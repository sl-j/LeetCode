package SString;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test {
    public static class Node{
        int val;
        Node next;
        public Node(){};
        public Node(int val){
            this.val = val;
        }
    }

    private static Node slove(Node head){
        if(head == null || head.next == null) return head;

        Node node = findMid(head);//寻找中间结点，断开链表
        //后面链表反转
        Node tailNode = reverse(node);

        Node preCur = tailNode;
        Node nextCur = head;

        Node res = new Node();
        Node cur = res;

        //交替更新
        while(preCur != null && nextCur != null){
            cur.next = preCur;
            preCur = preCur.next;
            cur.next.next = nextCur;
            nextCur = nextCur.next;
            cur = cur.next.next;
        }

        return res.next;
    }

    /**
     * 寻找中间部分
     * @param head
     * @return
     */
    private static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node node = slow.next;
        slow.next = null;
        return node;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private static Node reverse(Node head){
        Node pre = null;
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node node = slove(head);
        Node cur = node;

        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
