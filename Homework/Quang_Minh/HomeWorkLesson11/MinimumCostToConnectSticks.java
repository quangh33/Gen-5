package HomeWorkLesson11;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks)
            minHeap.offer(stick);
        int res = 0;
        while (minHeap.size() > 1) {
            int newStick = minHeap.poll() + minHeap.poll();
            res += newStick;
            minHeap.offer(newStick);
        }
        return res;
    }
}
