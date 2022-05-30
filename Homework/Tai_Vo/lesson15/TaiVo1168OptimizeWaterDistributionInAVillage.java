package lesson15;

import java.util.*;

/**
 * @author taivt
 * @link https://leetcode.com/problems/optimize-water-distribution-in-a-village/
 * @since 2022/05/30 20:33:05
 */
public class TaiVo1168OptimizeWaterDistributionInAVillage {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostToSupplyWater(3, new int[]{1, 2, 2}, new int[][]{{1, 2, 1}, {2, 3, 1}}));
        System.out.println(solution.minCostToSupplyWater(2, new int[]{1, 1}, new int[][]{{1, 2, 1}, {1, 2, 2}}));
        System.out.println(solution.minCostToSupplyWater(4, new int[]{1, 1, 1, 100}, new int[][]{{1, 2, 1}, {1, 3, 1}, {3, 4, 100}}));
    }

    // n: nodes, m: pipes.length
    // Space Complexity: O(n + m)
    // Time Complexity: O((n + m)log(n + m))
    private static class Solution {

        private static class DisjointSet {
            private final Map<Integer, Integer> parent = new HashMap<>();
            private int rootCount;

            public DisjointSet(int rootCount) {
                this.rootCount = rootCount;
            }

            public int find(int x) {
                Integer rootX = parent.getOrDefault(x, x);
                if (x == rootX) {
                    return x;
                }
                rootX = find(rootX);
                parent.put(x, rootX);
                return rootX;
            }

            public boolean union(int u, int v) {
                int rootU = find(u);
                int rootV = find(v);
                if (rootU == rootV) {
                    return false;
                } else {
                    parent.put(rootU, rootV);
                    rootCount--;
                    return true;
                }
            }

            public int getRootCount() {
                return rootCount;
            }
        }

        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[2]));
            for (int[] pipe : pipes) {
                minHeap.offer(pipe);
            }

            // Create a fake edge
            for (int i = 0; i < n; i++) {
                minHeap.offer(new int[]{0, i + 1, wells[i]});
            }

            DisjointSet disjointSet = new DisjointSet(n + 1);
            int cost = 0;
            while (!minHeap.isEmpty()) {
                int[] edge = minHeap.poll();
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (disjointSet.union(u, v)) {
                    cost += w;
                    if (disjointSet.getRootCount() == 1) {
                        break;
                    }
                }
            }

            return cost;
        }
    }
}
