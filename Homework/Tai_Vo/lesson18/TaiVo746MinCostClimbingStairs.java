package lesson18;

/**
 * @author taivt
 * @link https://leetcode.com/problems/min-cost-climbing-stairs/
 * @since 2022/06/05 21:50:43
 */
public class TaiVo746MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100}));
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    // n: cost.length
    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        private int[] dp;
        private int[] cost;

        public int minCostClimbingStairs(int[] cost) {
            this.cost = cost;
//            f = new int[cost.length];
//            Arrays.fill(f, -1);
//            return Math.min(recursive(cost.length - 1), recursive(cost.length - 2));

            return iterative(cost.length);
        }

        private int iterative(int n) {
            for (int i = 2; i < n; i++) {
                cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
            }
            return Math.min(cost[n - 1], cost[n - 2]);
        }

        private int recursive(int n) {
            if (n == 0 || n == 1) {
                return cost[n];
            }

            if (dp[n] != -1) {
                return dp[n];
            }

            int i1 = recursive(n - 1);
            int i2 = recursive(n - 2);
            return dp[n] = Math.min(i1, i2) + cost[n];
        }
    }
}
