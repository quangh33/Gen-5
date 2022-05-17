package lesson15;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author taivt
 * @link https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 * @since 2022/05/14 18:56:34
 */
public class TaiVo1101TheEarliestMomentWhenEveryoneBecomeFriends {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.earliestAcq(new int[][]{{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}}, 6));
        System.out.println(solution.earliestAcq(new int[][]{{0, 2, 0}, {1, 0, 1}, {3, 0, 3}, {4, 1, 2}, {7, 3, 1}}, 4));
        System.out.println(solution.earliestAcq(new int[][]{{9, 3, 0}, {0, 2, 1}, {8, 0, 1}, {1, 3, 2}, {2, 2, 0}, {3, 3, 1}}, 4));
    }

    // n: logs.length
    // Space Complexity: O(n)
    // Time Complexity: O(nlog(n))
    private static class Solution {

        private static class DisjointSet {
            private final int[] parent;
            private int nodes;

            private DisjointSet(int nodes) {
                parent = new int[nodes];
                for (int i = 0; i < parent.length; i++) {
                    parent[i] = i;
                }
                this.nodes = nodes;
            }

            public int find(int x) {
                if (x == parent[x]) {
                    return x;
                }
                return parent[x] = find(parent[x]);
            }

            public boolean union(int u, int v) {
                int rootU = find(u);
                int rootV = find(v);
                if (rootU == rootV) {
                    return false;
                } else {
                    parent[rootU] = rootV;
                    nodes--;
                    return true;
                }
            }

            public int getNodes() {
                return nodes;
            }
        }

        public int earliestAcq(int[][] logs, int n) {
            Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));
            DisjointSet disjointSet = new DisjointSet(n);
            for (int[] log : logs) {
                int timestamp = log[0];
                int x = log[1];
                int y = log[2];
                disjointSet.union(x, y);
                if (disjointSet.getNodes() == 1) {
                    return timestamp;
                }
            }
            return -1;
        }
    }
}
