package HomeWorkLesson3;

public class DesignCircularQueue {
}

class MyCircularQueue {
    int[] data;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
        data = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % data.length;
        size++;
        data[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % data.length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return data[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return data.length == size;
    }
}