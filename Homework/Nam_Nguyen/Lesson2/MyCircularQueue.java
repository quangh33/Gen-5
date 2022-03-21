package Homework.Nam_Nguyen.Lesson2;

public class MyCircularQueue {

    int[] queue;
    int head = -1;
    int tail = -1;
    int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[capacity];
    }
    
    public boolean enQueue(int value) {
        if (isFull())   return false;
        if (isEmpty())  head = 0;
        tail = (tail + 1)%capacity;
        queue[tail] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty())    return false;
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1)%capacity;
        return true;
    }
    
    public int Front() {
        if(isEmpty())   return -1;
        return queue[head];
    }
    
    public int Rear() {
        if(isEmpty())   return -1;
        return queue[tail];
    }
    
    public boolean isEmpty() {
        return head == -1;
    }
    
    public boolean isFull() {
        return ((tail + 1)%capacity) == head;
    }
    
}
