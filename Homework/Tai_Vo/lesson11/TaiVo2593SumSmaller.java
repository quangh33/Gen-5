package lesson11;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/3sum-smaller/
 * @since 2022/05/02 23:47:06
 */
public class TaiVo2593SumSmaller {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
        System.out.println(solution.threeSumSmaller(new int[]{-1, 1, -1, -1}, -1));
        System.out.println(solution.threeSumSmaller(new int[]{}, 0));
        System.out.println(solution.threeSumSmaller(new int[]{0}, 0));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n^2)
    private static class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                res += twoSumSmaller(nums, i + 1, target - nums[i]);
            }
            return res;
        }

        private int twoSumSmaller(int[] nums, int startIdx, int target) {
            int res = 0;
            int l = startIdx, r = nums.length - 1;
            while (l < r) {
                int twoSum = nums[l] + nums[r];
                if (twoSum < target) {
                    res += r - l;
                    l++;
                } else {
                    r--;
                }
            }
            return res;
        }
    }
}
