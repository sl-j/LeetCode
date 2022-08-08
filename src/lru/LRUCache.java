package lru;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public class Node{
        int key;
        int val;
        Node front;
        Node next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    int size;
    Node head;
    Node tail;
    Map<Integer,Node> cache;
    int capacity;
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.front = head;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        Node cur = cache.get(key);
        moveToTop(cur);

        return cur.val;
    }
    
    public void put(int key, int value) {
        Node cur = null;
        if(cache.containsKey(key)){
            cur = cache.get(key);
            moveToTop(cur);
            cur.val = value;
        }else{
            if(size == capacity){
                moveLast();
                size--;
            }
            cur = new Node(key,value); 
            Node headNext = head.next;
            head.next = cur;
            cur.next = headNext;
            cur.front = head;
            headNext.front = cur;
            cache.put(key,cur);
            size++;
        }
    }

    public void moveToTop(Node cur){
        Node pre = cur.front;
        Node next = cur.next;
        pre.next = next;
        next.front = pre;
        Node headNext = head.next;
        head.next = cur;
        cur.next = headNext;
        cur.front = head;
        headNext.front = cur;
    }

    public void moveLast(){
        Node pre = tail.front;
        pre.front.next = tail;
        tail.front = pre.front;
        pre.front = null;
        pre.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */