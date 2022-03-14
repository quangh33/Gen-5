package lession01;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sort-array-by-parity/
 * @since 2022/03/14 23:11:46
 */
public class TaiVo905SortArrayByParity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{1, 2, 3, 9, 8, 3, 1, 2, 4})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{0})));
    }

    private static class Solution {
        public int[] sortArrayByParity(int[] nums) {
            // Space Complexity: O(1)
            // Time Complexity: O(n)
            int leftEven = 0;
            int rightOdd = nums.length - 1;

            while (leftEven < rightOdd) {
                if (nums[leftEven] % 2 == 0) {
                    leftEven++;
                    continue;
                }

                if (nums[rightOdd] % 2 == 1) {
                    rightOdd--;
                    continue;
                }

                int temp = nums[leftEven];
                nums[leftEven] = nums[rightOdd];
                nums[rightOdd] = temp;

                leftEven++;
                rightOdd--;
            }

            return nums;
        }
    }
}
