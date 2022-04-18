package lesson08;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taivt
 * @link https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * @since 2022/04/15 00:58:51
 */
public class TaiVo1091ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0}}));
    }

    // n: number of cells
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private final int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        private int height;
        private int width;

        public int shortestPathBinaryMatrix(int[][] grid) {
            height = grid.length;
            width = grid[0].length;
            if (grid[0][0] == 1 || grid[height - 1] [width - 1] == 1) {
                return -1;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int distance = grid[row][col];
                if (row == height - 1 && col == width - 1) {
                    return distance + 1;
                }

                for (int i = 0; i < 8; i++) {
                    int nextRow = row + directions[i][0];
                    int nextCol = col + directions[i][1];
                    if (isInbound(nextRow, nextCol) && grid[nextRow][nextCol] == 0) {
                        grid[nextRow][nextCol] = distance + 1;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
            return -1;
        }

        private boolean isInbound(int row, int col) {
            return row >= 0 && row < height && col >= 0 && col < width;
        }
    }
}
