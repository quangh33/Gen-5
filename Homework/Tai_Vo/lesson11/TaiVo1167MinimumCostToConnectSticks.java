package lesson11;

import java.util.PriorityQueue;

/**
 * @author taivt
 * @link https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 * @since 2022/05/09 00:19:19
 */
public class TaiVo1167MinimumCostToConnectSticks {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.connectSticks(new int[]{2, 4, 3}));
        System.out.println(solution.connectSticks(new int[]{1, 8, 3, 5}));
        System.out.println(solution.connectSticks(new int[]{5}));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n * log(n))
    private static class Solution {
        public int connectSticks(int[] sticks) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int stick : sticks) {
                minHeap.add(stick);
            }

            int cost = 0;
            while (minHeap.size() > 1) {
                Integer curCost = minHeap.poll();
                if (!minHeap.isEmpty()) {
                    curCost += minHeap.poll();
                }
                minHeap.add(curCost);
                cost += curCost;
            }

            return cost;
        }
    }
}
