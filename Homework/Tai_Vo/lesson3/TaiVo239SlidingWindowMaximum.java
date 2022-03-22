package lesson3;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sliding-window-maximum/
 * @since 2022/03/22 21:03:52
 */
public class TaiVo239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(result));
    }

    // Space Complexity: O(k)
    // Time Complexity: O((n - k) * k)
    private static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            int resIdx = 0;

            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (deque.peekFirst() != null && (i - k) == deque.peekFirst()) {
                    deque.removeFirst();
                }

                while (deque.peekLast() != null && nums[deque.peekLast()] < nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);

                if ((i + 1) - k >= 0) {
                    res[resIdx++] = nums[deque.getFirst()];
                }
            }
            return res;
        }
    }
}
