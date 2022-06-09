package lesson18;

/**
 * @author taivt
 * @link https://leetcode.com/problems/paint-house/
 * @since 2022/06/10 00:27:20
 */
public class TaiVo256PaintHouse {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(solution.minCost(new int[][]{{7, 6, 2}}));
    }

    // n: costs.length
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private static final int RED = 0, BLUE = 1, GREEN = 2;

        public int minCost(int[][] costs) {
            int n = costs.length;
            int[][] dp = new int[n][3]; // dp[i][j] is the cost if painting the ith house with color j
            dp[0][RED] = costs[0][RED];
            dp[0][BLUE] = costs[0][BLUE];
            dp[0][GREEN] = costs[0][GREEN];

            for (int i = 1; i < n; i++) {
                dp[i][RED] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][RED];
                dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][2]) + costs[i][BLUE];
                dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + costs[i][GREEN];
            }

            return Math.min(Math.min(dp[n - 1][RED], dp[n - 1][BLUE]), dp[n - 1][GREEN]);
        }
    }
}
