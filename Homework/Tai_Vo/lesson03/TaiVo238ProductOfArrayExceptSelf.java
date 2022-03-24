package lesson03;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/product-of-array-except-self/
 * @since 2022/03/24 23:12:54
 */
public class TaiVo238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] prefixProducts = new int[nums.length];
            prefixProducts[0] = nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                prefixProducts[i] = prefixProducts[i - 1] * nums[i];
            }

            int suffixProductSoFar = 1;
            for (int i = nums.length - 1; i > 0; i--) {
                prefixProducts[i] = prefixProducts[i - 1] * suffixProductSoFar;
                suffixProductSoFar *= nums[i];
            }
            prefixProducts[0] = suffixProductSoFar;
            return prefixProducts;
        }
    }
}
