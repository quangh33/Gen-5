package lesson09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author taivt
 * @link https://leetcode.com/problems/rotting-oranges/
 * @since 2022/04/20 21:34:08
 */
public class TaiVo994RottingOranges {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(solution.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(solution.orangesRotting(new int[][]{{0, 2}}));
    }

    // n: rows, m: cols
    // Space Complexity: O(n * m)
    // Time Complexity: O(n * m)
    private static class Solution {
        private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        private int rows;
        private int cols;

        public int orangesRotting(int[][] grid) {
            rows = grid.length;
            cols = grid[0].length;

            Queue<int[]> queue = new LinkedList<>();
            int nOfFresh = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        nOfFresh++;
                    } else if (grid[i][j] == 2) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            if (queue.isEmpty() && nOfFresh == 0) {
                return 0;
            }

            int minutesElapsed = -1;
            while (!queue.isEmpty()) {
                minutesElapsed++;
                List<int[]> nextLevel = new ArrayList<>();
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int curRow = cur[0];
                    int curCol = cur[1];
                    for (int[] direction : directions) {
                        int nextRow = curRow + direction[0];
                        int nextCol = curCol + direction[1];
                        if (withinBoundary(nextRow, nextCol) && grid[nextRow][nextCol] == 1) {
                            nextLevel.add(new int[]{nextRow, nextCol});
                            grid[nextRow][nextCol] = 2;
                            nOfFresh--;
                        }
                    }
                }
                queue.addAll(nextLevel);
            }

            return nOfFresh > 0 ? -1 : minutesElapsed;
        }

        private boolean withinBoundary(int row, int col) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }
    }
}
