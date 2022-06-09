package lesson15;

import java.util.*;

/**
 * @author taivt
 * @link https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * @since 2022/05/13 19:30:33
 */
public class TaiVo787CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));
        System.out.println(solution.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(solution.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
        System.out.println(solution.findCheapestPrice(5, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}, {3, 4, 1}}, 0, 4, 2));
        System.out.println(solution.findCheapestPrice(10, new int[][]{{0, 1, 20}, {1, 2, 20}, {2, 3, 30}, {3, 4, 30}, {4, 5, 30}, {5, 6, 30}, {6, 7, 30}, {7, 8, 30}, {8, 9, 30}, {0, 2, 9999}, {2, 4, 9998}, {4, 7, 9997}}, 0, 9, 4));
    }

    // n: nodes, m: edges
    // Space Complexity: O(n ^ 2)
    // Time Complexity: O(n ^ 2 * log(n))
    private static class Solution {

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            //  source       dest     weight
            Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                Map<Integer, Integer> neighbours = adj.computeIfAbsent(u, key -> new HashMap<>());
                neighbours.put(v, w);
            }

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0]));
            int[][] currentStops = new int[n][n + 1];
            for (int[] arr : currentStops) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }

            currentStops[src][0] = 0;
            //        distanceSoFar, src, stops
            minHeap.add(new int[]{0, src, 0});
            while (!minHeap.isEmpty()) {
                int[] pair = minHeap.poll();
                int distanceSoFar = pair[0];
                int u = pair[1];
                int stops = pair[2];
                if (u == dst) {
                    return distanceSoFar;
                } else if (stops > k) {
                    continue;
                }

                Map<Integer, Integer> neighbours = adj.getOrDefault(u, Collections.emptyMap());
                for (Map.Entry<Integer, Integer> entry : neighbours.entrySet()) {
                    Integer v = entry.getKey();
                    Integer w = entry.getValue();
                    int newDistanceToV = distanceSoFar + w;
                    if (newDistanceToV < currentStops[v][stops + 1]) {
                        currentStops[v][stops + 1] = newDistanceToV;
                        minHeap.offer(new int[]{newDistanceToV, v, stops + 1});
                    }
                }
            }

            return -1;
        }
    }
}
