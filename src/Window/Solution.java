package Window;

import java.util.*;


public class Solution {
    
    public class Node{
        int key;
        int val;
        Node pre;
        Node next;
        
        Node(){}
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    
    public Node head;
    public Node tail;
    Map<Integer,Node> map;
    int capacity = 0;
    public Solution(int capacity) {
         // write code here
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
         // write code here
        if(!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        moveToTop(cur);
        return cur.val;
    }

    public void set(int key, int value) {
         // write code here
        if(map.size() >= capacity){
            int num = tail.pre.key;
            moveLast();
            map.remove(Integer.valueOf(num));
        }
        if(!map.containsKey(key)){
            Node cur = new Node(key,value);
            map.put(key,cur);
            insertToTop(cur);
        }else{
            Node cur = map.get(key);
            cur.val = value;
            moveToTop(cur);
        }
    }
    
    private void moveToTop(Node cur){
        cur.pre.next = cur.next.next;
        cur.next.pre = cur.pre;
        
        Node headNext = head.next;
        head.next = cur;
        cur.pre = head;
        cur.next = headNext;
        headNext.pre = cur;
    }
    
    private void moveLast(){
        Node tailPre = tail.pre;
        tailPre.pre.next = tail;
        tail.pre = tailPre.pre;
        
        tailPre.pre = null;
        tailPre.next = null;
    }
    
    private void insertToTop(Node cur){
        Node headNext = head.next;
        head.next = cur;
        cur.next = headNext;
        cur.pre = head;
        headNext.pre = cur;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution solution = new Solution(capacity);
 * int output = solution.get(key);
 * solution.set(key,value);
 */