package lession01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taivt
 * @link https://leetcode.com/problems/subsets/
 * @since 2022/03/17 23:58:39
 */
public class TaiVo78Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new Solution().subsets(nums);
        System.out.println(subsets);
    }

    // Space Complexity: O(2^n)
    // Time Complexity: O(2^n * n)
    private static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> results = new ArrayList<>(nums.length);
            for (int bitmask = 0; bitmask < Math.pow(2, nums.length); bitmask++) {
                List<Integer> subset = new ArrayList<>();
                for (int pos = 0; pos < nums.length; pos++) {
                    if (getBit(bitmask, pos) == 1) {
                        subset.add(nums[pos]);
                    }
                }
                results.add(subset);
            }
            return results;
        }

        private int getBit(int bitmask, int pos) {
            return (bitmask >> pos) & 1;
        }
    }
}
