package queue;

class MyCircularDeque {

    private int[] data;
    private int front;
    private int end;
    private int size;
    private int capable;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        data = new int[k];
        size = k;
        capable = k;
        front = 0;
        end = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        data[front] = value;
        front++;
        front %= size;
        capable--;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        end = (--end + size) % size;
        data[end] = value;
        capable--;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front--;
        front = (front + size) % size;
        capable++;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        end++;
        end %= size;
        capable++;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (!isEmpty()) {
            int index = (front - 1 + size) % size;
            return data[index];
        }
        return -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (!isEmpty()) {
            return data[end];
        }
        return -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return capable == size;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return capable <= 0;
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