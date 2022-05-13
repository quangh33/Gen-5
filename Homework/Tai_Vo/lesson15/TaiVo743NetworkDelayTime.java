package lesson15;

import java.util.*;

/**
 * @author taivt
 * @link https://leetcode.com/problems/network-delay-time/
 * @since 2022/05/12 18:27:00
 */
public class TaiVo743NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
        System.out.println(solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
    }

    // n: nodes, m: edges
    // Space Complexity: O(n + m)
    // Time Complexity: O(n)
    private static class Solution {
        private static final int INF = -1;

        public int networkDelayTime(int[][] times, int n, int k) {
            //  source       dest     weight
            Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];
                Map<Integer, Integer> neighbours = adj.computeIfAbsent(u, missKey -> new HashMap<>());
                neighbours.put(v, w);
            }

            int[] distances = new int[n + 1];
            Arrays.fill(distances, INF);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // start from k
            distances[k] = 0;
            minHeap.offer(k);

            while (!minHeap.isEmpty()) {
                Integer u = minHeap.poll();
                Map<Integer, Integer> neighbours = adj.getOrDefault(u, Collections.emptyMap());
                for (Map.Entry<Integer, Integer> entry : neighbours.entrySet()) {
                    Integer v = entry.getKey();
                    Integer w = entry.getValue();
                    int distanceAtV = distances[v];
                    int newWeightToV = distances[u] + w;
                    if (distanceAtV == INF || newWeightToV < distanceAtV) {
                        distances[v] = newWeightToV;
                        minHeap.offer(v);
                    }
                }
            }

            int res = -1;
            for (int i = 1; i <= n; i++) {
                if (distances[i] == -1) {
                    return -1;
                }
                res = Math.max(res, distances[i]);
            }
            return res;
        }
    }
}
