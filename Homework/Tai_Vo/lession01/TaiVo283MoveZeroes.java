package lession01;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/move-zeroes/
 * @since 2022/03/14 21:13:06
 */
public class TaiVo283MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {0};
        new Solution().moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1, 0, 2, 3, 8, 0, 4, 5, 6, 0};
        new Solution().moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public void moveZeroes(int[] nums) {
            int cur = 0;
            int nextNonZeroIdx = 1;

            while (nextNonZeroIdx < nums.length) {
                if (nums[cur] == 0) {
                    // Move nextNonZeroIdx to the right
                    while (nextNonZeroIdx < nums.length) {
                        // Found a non-zero element
                        if (nums[nextNonZeroIdx] != 0) {
                            nums[cur] = nums[nextNonZeroIdx];
                            nums[nextNonZeroIdx] = 0;
                            break;
                        }
                        nextNonZeroIdx++;
                    }
                }
                cur++;
                nextNonZeroIdx++;
            }
        }
    }
}
