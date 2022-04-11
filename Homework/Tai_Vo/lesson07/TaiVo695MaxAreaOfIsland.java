package lesson07;

/**
 * @author taivt
 * @link https://leetcode.com/problems/max-area-of-island/
 * @since 2022/04/06 23:14:33
 */
public class TaiVo695MaxAreaOfIsland {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // @formatter:off
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        // @formatter:on
        System.out.println(solution.maxAreaOfIsland(grid));
    }

    // n: height, m: width
    // Space Complexity: O(n * m)
    // Time Complexity: O(n * m)
    private static class Solution {
        private int[][] visited;
        int height = 0;
        int width = 0;
        private final int[] dx = {0, 1, 0, -1};
        private final int[] dy = {-1, 0, 1, 0};

        public int maxAreaOfIsland(int[][] grid) {
            height = grid.length;
            width = grid[0].length;
            visited = new int[height][width];

            int maxArea = 0;
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (grid[row][col] == 1 && visited[row][col] == 0) {
                        int curArea = dfs(grid, row, col);
                        maxArea = Math.max(curArea, maxArea);
                    }
                }
            }

            return maxArea;
        }

        private int dfs(int[][] grid, int row, int col) {
            visited[row][col] = 1;
            if (grid[row][col] == 0) {
                return 0;
            }

            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nRow = row + dy[i];
                int nCol = col + dx[i];
                if (isInbound(nRow, nCol) && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0) {
                    count += dfs(grid, nRow, nCol);
                }
            }

            return count + 1;
        }

        private boolean isInbound(int row, int col) {
            return (row >= 0 && row < height) && (col >= 0 && col < width);
        }
    }
}
