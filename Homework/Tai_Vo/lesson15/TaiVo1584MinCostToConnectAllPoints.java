package lesson15;

import java.util.*;

/**
 * @author taivt
 * @link https://leetcode.com/problems/min-cost-to-connect-all-points/
 * @since 2022/05/17 21:05:59
 */
public class TaiVo1584MinCostToConnectAllPoints {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(solution.minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
        System.out.println(solution.minCostConnectPoints(new int[][]{{0, 0}}));
        System.out.println(solution.minCostConnectPoints(new int[][]{{2, -3}, {-17, -8}, {13, 8}, {-17, -15}}));
    }

    // n: the number of points
    // Space Complexity: O(n ^ 2)
    // Time Complexity: O(n^2 * log(n^2))
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

        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            // u, v, w
            List<int[]> edges = new ArrayList<>((n * (n - 1)) / 2);
            for (int u = 0; u < n; u++) {
                int x1 = points[u][0];
                int y1 = points[u][1];
                for (int v = u + 1; v < n; v++) {
                    int x2 = points[v][0];
                    int y2 = points[v][1];
                    int distance = calDistance(x1, y1, x2, y2);
                    edges.add(new int[]{u, v, distance});
                }
            }

            DisjointSet disjointSet = new DisjointSet(n);
            edges.sort(Comparator.comparingInt(value -> value[2]));
            int totalCost = 0;
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (disjointSet.union(u, v)) {
                    totalCost += w;
                    if (disjointSet.getRootCount() == 1) {
                        break;
                    }
                }
            }

            return totalCost;
        }

        private int calDistance(int x1, int y1, int x2, int y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }
    }
}
