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
            Map<Integer, Integer> sumFreq1 = calculateSumFrequency(nums1, nums2);
            Map<Integer, Integer> sumFreq2 = calculateSumFrequency(nums3, nums4);

            int count = 0;
            for (Map.Entry<Integer, Integer> entry : sumFreq1.entrySet()) {
                Integer sum1 = entry.getKey();
                Integer freq = entry.getValue();
                count += (freq * sumFreq2.getOrDefault(-sum1, 0));
            }
            return count;
        }

        private Map<Integer, Integer> calculateSumFrequency(int[] nums1, int[] nums2) {
            int length = nums1.length;
            Map<Integer, Integer> sumFrequency = new HashMap<>();
            for (int i = 0; i < length; i++) {
                int num1 = nums1[i];
                for (int j = 0; j < length; j++) {
                    int num2 = nums2[j];
                    int sum = num1 + num2;
                    sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
                }
            }
            return sumFrequency;
        }
    }
}
