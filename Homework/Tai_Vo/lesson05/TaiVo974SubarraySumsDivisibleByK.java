package lesson05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * @since 2022/03/28 23:22:56
 */
public class TaiVo974SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(solution.subarraysDivByK(new int[]{5}, 9));
    }

    // Space Complexity: O(k)
    // Time Complexity: O(n)
    private static class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            int sumSoFar = 0;
            int count = 0;
            for (int num : nums) {
                sumSoFar = sumSoFar + num;
                int remainder = sumSoFar % k;

                if (remainder < 0) {
                    remainder = remainder + k;
                }

                Integer prevRemainder = map.getOrDefault(remainder, 0);
                count = count + prevRemainder;
                map.put(remainder, prevRemainder + 1);
            }

            return count;
        }
    }
}
