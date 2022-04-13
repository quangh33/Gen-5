package lesson05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/4sum-ii/
 * @since 2022/03/30 22:18:20
 */
public class TaiVo454FourSumII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        System.out.println(solution.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
    }

    // Space Complexity: O(n^2)
    // Time Complexity: O(n^2)
    private static class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> sumFreq1 = new HashMap<>();
            for (int num1 : nums1) {
                for (int num2 : nums2) {
                    int sum = num1 + num2;
                    sumFreq1.put(sum, sumFreq1.getOrDefault(sum, 0) + 1);
                }
            }

            int count = 0;
            for (int num3 : nums3) {
                for (int num4 : nums4) {
                    int sum = num3 + num4;
                    count += sumFreq1.getOrDefault(-sum, 0);
                }
            }
            return count;
        }
    }
}
