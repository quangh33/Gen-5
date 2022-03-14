package lession01;

/**
 * @author taivt
 * @since 2022/03/13 23:16:24
 * @link https://leetcode.com/problems/single-number/
 */
public class TaiVo136SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int singleNum = new Solution().singleNumber(nums);
        System.out.println(singleNum);
    }

    private static class Solution {
        public int singleNumber(int[] nums) {
            // Space Complexity: O(1)
            // Time Complexity: O(n)
            int singleNum = 0;
            for (int num : nums) {
                singleNum ^= num;
            }
            return singleNum;
        }
    }
}
