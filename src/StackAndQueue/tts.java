package StackAndQueue;

public class tts {

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(1);
        lru.put(2,1);
        lru.get(2);
        lru.put(3,2);
        lru.get(2);
        lru.get(3);

    }
}
