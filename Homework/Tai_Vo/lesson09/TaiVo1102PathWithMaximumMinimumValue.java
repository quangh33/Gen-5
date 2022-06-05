package lesson09;

/**
 * @author taivt
 * @link https://leetcode.com/problems/path-with-maximum-minimum-value/
 * @since 2022/04/18 21:01:08
 */
public class TaiVo1102PathWithMaximumMinimumValue {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumMinimumPath(new int[][]{{5, 4, 5}, {1, 2, 6}, {7, 4, 6}}));
        System.out.println(solution.maximumMinimumPath(new int[][]{{2, 2, 1, 2, 2, 2}, {1, 2, 2, 2, 1, 2}}));
        System.out.println(solution.maximumMinimumPath(new int[][]{{3, 4, 6, 3, 4}, {0, 2, 1, 1, 7}, {8, 8, 3, 2, 7}, {3, 2, 4, 9, 8}, {4, 1, 2, 0, 0}, {4, 6, 5, 4, 3}}));
    }

    // n: rows, m: cols, k: largest value in the matrix
    // Space Complexity: O(n * m)
    // Time Complexity: O(log(k) * n * m)
    private static class Solution {
        private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        private int rows;
        private int cols;

        public int maximumMinimumPath(int[][] grid) {
            rows = grid.length;
            cols = grid[0].length;

            int low = 0;
            int high = Math.min(grid[0][0], grid[rows - 1][cols - 1]);
            int res = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                boolean[][] visited = new boolean[rows][cols];
                boolean exists = pathExists(grid, mid, visited, 0, 0);
                if (exists) {
                    res = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return res;
        }

        private boolean pathExists(int[][] grid, int val, boolean[][] visited, int curRow, int curCol) {
            if (curRow == rows - 1 && curCol == cols - 1) {
                return true;
            }

            visited[curRow][curCol] = true;
            for (int[] direction : directions) {
                int newRow = curRow + direction[0];
                int newCol = curCol + direction[1];

                if (withinBoundary(newRow, newCol) && !visited[newRow][newCol] && grid[newRow][newCol] >= val) {
                    if (pathExists(grid, val, visited, newRow, newCol)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean withinBoundary(int row, int col) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }
    }
}
