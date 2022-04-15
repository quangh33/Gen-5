package lesson08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taivt
 * @link https://leetcode.com/problems/01-matrix/
 * @since 2022/04/15 21:05:33
 */
public class TaiVo54201Matrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})));
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }

    private static class Solution {
        private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        private int rows;
        private int cols;

        public int[][] updateMatrix(int[][] mat) {
            rows = mat.length;
            cols = mat[0].length;
            int[][] distances = new int[rows][cols];

            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 0) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int distance = distances[row][col];
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + directions[i][0];
                    int nextCol = col + directions[i][1];
                    if (withinBoundary(nextRow, nextCol) && mat[nextRow][nextCol] == 1) {
                        if (distances[nextRow][nextCol] == 0) {
                            distances[nextRow][nextCol] = distance + 1;
                            queue.add(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }

            return distances;
        }

        private boolean withinBoundary(int row, int col) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }
    }
}
