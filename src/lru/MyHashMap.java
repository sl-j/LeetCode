package lru;

class MyHashMap {

    public class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int size;
    private static double LOAD_FACTOR = 0.75;

    public MyHashMap() {
        size = 0;
        buckets = new Node[16];
    }
    
    public void put(int key, int value) {
        int index = key % buckets.length;

        if(buckets[index] == null){
            buckets[index] = new Node(key,value);
        }else{
            Node dummy = new Node(0,0);
            dummy.next = buckets[index];
            Node cur = dummy;

            while(cur.next != null && cur.next.key != key){
                cur = cur.next;
            }

            if(cur.next != null && cur.next.key == key) cur.next.value = value;
            else{
                while(cur.next != null){
                    cur = cur.next;
                }
                Node newNode = new Node(key,value);
                cur.next = newNode;
                size++;
                if(buckets.length * LOAD_FACTOR >= size){
                    exrand();
                }
            }
        }
    }

    public int get(int key) {
        int index = key % buckets.length;
        Node cur = buckets[index];

        while(cur != null && cur.key != key){
            cur = cur.next;
        }

        return cur == null ? -1 : cur.value;

    }
    
    public void remove(int key) {
        int index = key % buckets.length;
        Node dummy = new Node(0,0);
        dummy.next = buckets[index];
        Node cur = dummy;

        while(cur.next != null && cur.next.key != key){
            cur = cur.next;
        }

        if(cur.next != null && cur.next.key == key) cur.next = cur.next.next;
        buckets[index] = dummy.next;
    }

    public void exrand(){
        Node[] oldBucekts = buckets;
        Node[] newBuckets = new Node[oldBucekts.length * 2];
        buckets = newBuckets;

        for(Node cur : oldBucekts){
            while(cur != null){
                put(cur.key,cur.value);
                cur = cur.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */