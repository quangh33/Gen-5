package lession01;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sort-array-by-parity-ii/
 * @since 2022/03/14 23:35:19
 */
public class TaiVo922SortArrayByParityII {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7})));
//        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{2, 3})));
//        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{3, 4, 6, 8, 5, 7})));
//        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{3, 5, 2, 4, 6, 7})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{3, 1, 4, 2})));
//        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{648, 831, 560, 986, 192, 424, 997, 829, 897, 843})));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            /*
            Note: (a % 2 == b % 2) means a and b are both even or odd => a and b are the same type
            The idea is that I have two pointers run from left to right:
                1. curIdx (start at 0): current index
                2. nextOppositeTypeIdx (start at 1): the next index where nums[nextOppositeTypeIdx] % 2 == curIdx % 2 (both even or both odd)
            For nextOppositeTypeIdx = 1 => nums.length -1. When curIdx and nums[curIdx] are not the same type:
                1. Move nextOppositeTypeIdx -> right to find a num[nextOppositeTypeIdx] which is same type with curIdx
                2. Swap (nums[curIdx], nums[nextOppositeTypeIdx])
                3. Move curIdx next and continue the loop
             */
            int curIdx = 0;
            int nextOppositeTypeIdx = 1;
            while (nextOppositeTypeIdx < nums.length) {
                if (curIdx % 2 != nums[curIdx] % 2) {   // Not both even or both odd
                    // Move nextOppositeTypeIdx to the right
                    while (nextOppositeTypeIdx < nums.length) {
                        if (curIdx % 2 == nums[nextOppositeTypeIdx] % 2) { // curIdx and nums[nextOppositeTypeIdx] are the same type
                            // Swap (nums[curIdx], nums[nextOppositeTypeIdx])
                            int temp = nums[curIdx];
                            nums[curIdx] = nums[nextOppositeTypeIdx];
                            nums[nextOppositeTypeIdx] = temp;
                            break;
                        }
                        nextOppositeTypeIdx++;
                    }
                }

                curIdx++;
                if (curIdx == nextOppositeTypeIdx) {
                    nextOppositeTypeIdx++;
                }
            }
            return nums;
        }
    }
}
