package lesson18;

/**
 * @author taivt
 * @link https://leetcode.com/problems/longest-increasing-subsequence/
 * @since 2022/06/05 23:19:09
 */
public class TaiVo300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    // n: nums.length
    // Space Complexity: O(n)
    // Time Complexity: O(n ^ 2)
    private static class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] f = new int[n]; // f[i] is the longest increasing subsequence that ended at i
            f[0] = 1;
            for (int i = 1; i < n; i++) {
                int maxCount = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < nums[i]) {
                        maxCount = Math.max(maxCount, f[j]);
                    }
                }
                f[i] = maxCount + 1;
            }

            int longest = 0;
            for (int i : f) {
                if (i > longest) {
                    longest = Math.max(longest, i);
                }
            }
            return longest;
        }
    }
}
