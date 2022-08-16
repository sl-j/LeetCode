package StackAndQueue;

class MyCircularDeque {
    int[] nums;
    int head,tail,size;

    public MyCircularDeque(int k) {
        nums = new int[k];
        head = nums.length;
        tail = -1;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(head == nums.length) head = nums.length - 1;
        nums[head--] = value;
        size++;
        return true;

    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(tail == -1) tail = 0;
        nums[tail++] = value;
        size++;
        return true;

    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(head == nums.length) head = 0;
        head++;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(tail == -1) tail = nums.length - 1;
        tail--;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return nums[head];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return nums[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == nums.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */