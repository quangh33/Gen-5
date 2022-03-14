package lession01;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sort-array-by-parity-ii/
 * @since 2022/03/14 23:35:19
 */
public class TaiVo922SortArrayByParityII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{2, 3})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{3, 4, 6, 8, 5, 7})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{3, 5, 2, 4, 6, 7})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{648, 831, 560, 986, 192, 424, 997, 829, 897, 843})));
    }

    private static class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            // Space Complexity: O(1)
            // Time Complexity: O(n)
            int curIdx = 0;
            int nextOppositeTypeIdx = 1;
            while (nextOppositeTypeIdx < nums.length) {
                if (curIdx == nextOppositeTypeIdx) {
                    nextOppositeTypeIdx++;
                }
                if (curIdx % 2 == nums[curIdx] % 2) {
                    curIdx++;
                    continue;
                }

                if (nums[nextOppositeTypeIdx] % 2 == nextOppositeTypeIdx % 2
                        || nums[nextOppositeTypeIdx] % 2 != curIdx % 2) {
                    nextOppositeTypeIdx++;
                    continue;
                }

                int temp = nums[curIdx];
                nums[curIdx] = nums[nextOppositeTypeIdx];
                nums[nextOppositeTypeIdx] = temp;
                curIdx++;
            }
            return nums;
        }
    }
}
