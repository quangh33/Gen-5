package lesson3;

/**
 * @author taivt
 * @link https://leetcode.com/problems/design-circular-queue/
 * @since 2022/03/25 01:44:36
 */
public class TaiVo622DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(9)); // return True
        System.out.println(myCircularQueue.enQueue(5)); // return True
        System.out.println(myCircularQueue.enQueue(0)); // return False
        System.out.println(myCircularQueue.deQueue());     // return 3
        System.out.println(myCircularQueue.deQueue());   // return True
        System.out.println(myCircularQueue.isEmpty());  // return True
        System.out.println(myCircularQueue.isEmpty()); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
        System.out.println(myCircularQueue.Rear());     // return 4
        System.out.println(myCircularQueue.deQueue());     // return 4
    }

    // Space Complexity: O(n)
    private static class MyCircularQueue {
        private final int[] ringBuffer;
        private final int maxSize;
        private int curSize = 0;
        private int head = 0;
        private int tail = -1;

        public MyCircularQueue(int k) {
            ringBuffer = new int[k];
            this.maxSize = k;
        }

        // Time Complexity: O(1)
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            tail = (tail + 1) % maxSize;
            ringBuffer[tail] = value;
            curSize++;
            return true;
        }

        // Time Complexity: O(1)
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            ringBuffer[head] = 0;
            head = (head + 1) % maxSize;
            curSize--;
            return true;
        }

        // Time Complexity: O(1)
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return ringBuffer[head];
        }

        // Time Complexity: O(1)
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return ringBuffer[tail];
        }

        // Time Complexity: O(1)
        public boolean isEmpty() {
            return curSize == 0;
        }

        // Time Complexity: O(1)
        public boolean isFull() {
            return curSize == maxSize;
        }
    }

}
