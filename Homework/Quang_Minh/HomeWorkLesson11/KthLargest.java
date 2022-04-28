package HomeWorkLesson11;

import java.util.PriorityQueue;

public class KthLargest {
    final PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            maxHeap.offer(num);
        }
        while (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }

    public int add(int val) {
        maxHeap.offer(val);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
