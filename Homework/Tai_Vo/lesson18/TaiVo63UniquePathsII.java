package lesson18;

/**
 * @author taivt
 * @link https://leetcode.com/problems/unique-paths-ii/
 * @since 2022/06/09 22:02:10
 */
public class TaiVo63UniquePathsII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{1}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{1, 0}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));
    }

    // n: grid.length, m: grid[0].length
    // Space Complexity: O(n * m)
    // Time Complexity: O(n * m)
    private static class Solution {

        public int uniquePathsWithObstacles(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
                return 0;
            }

            int[][] dp = new int[n][m];  // the number of unique paths when considering grid[0...i][0...j]
            dp[0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        continue;
                    }
                    if (i - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }

            return dp[n - 1][m - 1];
        }

    }
}
