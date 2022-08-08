package SString;

class MyCircularQueue {
    int[] queue;
    int head;
    int tail;
    int k;
    public MyCircularQueue(int k) {
        this.k = k;
        queue = new int[k];
        head = -1;
        tail = -1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;

        tail = (++tail) % k;
        queue[tail] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        head = (--head) % k;
        if(head == tail){
            head = -1;
            tail = -1;
        }


        return true;
    }
    
    public int Front() {
        return queue[head];
    }
    
    public int Rear() {
        return queue[tail];
    }
    
    public boolean isEmpty() {
        return head == tail;
    }
    
    public boolean isFull() {
        return (tail + 1) % k == head;
    }
}