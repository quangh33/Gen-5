package Homework.Nam_Nguyen.Lesson11;

import java.util.PriorityQueue;

public class LeetCode_703_KthLargestElementsInStream {

    private PriorityQueue<Integer> minHeapQueue = new PriorityQueue<>();
    int capacity;

    public LeetCode_703_KthLargestElementsInStream(int k, int[] nums) {
        capacity = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(minHeapQueue.size() < capacity) {
            minHeapQueue.add(val);
        }else {
            if(val > minHeapQueue.peek()) {
                minHeapQueue.add(val);
                minHeapQueue.poll();
            }   
        }
        return minHeapQueue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        new LeetCode_703_KthLargestElementsInStream(k, nums);
    }
}