package lesson18;

/**
 * @author taivt
 * @link https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * @since 2022/06/07 23:16:10
 */
public class TaiVo718MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(solution.findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}));
        System.out.println(solution.findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}));
    }

    // n: s.length, m: t.length
    // Space Complexity: O(n * m)
    // Time Complexity: O(n * m)
    private static class Solution {
        public int findLength(int[] s, int[] t) {
            int n = s.length;
            int m = t.length;
            int[][] dp = new int[n + 1][m + 1]; // dp[i][j] the len of the longest repeated subarray when considering s[0...i]t[0...j]
            int longest = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s[i - 1] == t[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        longest = Math.max(longest, dp[i][j]);
                    }
                }
            }

            return longest;
        }
    }
}
