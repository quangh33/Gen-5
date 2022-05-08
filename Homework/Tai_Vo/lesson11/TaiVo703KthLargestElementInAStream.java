package lesson11;

import java.util.PriorityQueue;

/**
 * @author taivt
 * @link https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * @since 2022/05/09 00:33:23
 */
public class TaiVo703KthLargestElementInAStream {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    // n: nums.length, m: the number of calls to add()
    // Space Complexity: O(n)
    // Time Complexity: O(n * log(k) + m * log(k))
    private static class KthLargest {
        private final int k;
        private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                minHeap.offer(num);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        public int add(int val) {
            minHeap.offer(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }

}
