package HomeWorkLesson3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SlidingWindowMaximum {
    Deque<Integer> deque = new ArrayDeque<Integer>();
    int[] a;

    public int[] maxSlidingWindow(int[] nums, int k) {
        a = nums;
        int size = nums.length;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < size; i++) {
            push(i);
            if (i >= k-1) {
                res[index] = a[deque.getFirst()];
                index ++;
                if (deque.getFirst() <= i - k + 1) deque.removeFirst();
            }
        }
        return  res;

    }

    public void push(int i) {
        while (!deque.isEmpty() && a[deque.getLast()] < a[i]) {
            deque.removeLast();
        }
        deque.addLast(i);
    }

}
