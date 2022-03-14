package lession01;

import java.util.Arrays;

/**
 * @author taivt
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

        int[] nums3 = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        new Solution().moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    private static class Solution {
        public void moveZeroes(int[] nums) {
            int slowIdx = 0;
            int fastIdx = 1;

            while (fastIdx < nums.length && slowIdx < nums.length) {
                if (nums[slowIdx] == 0) {
                    while (fastIdx < nums.length) {
                        if (nums[fastIdx] != 0) {
                            int temp = nums[slowIdx];
                            nums[slowIdx] = nums[fastIdx];
                            nums[fastIdx] = temp;
                            break;
                        }
                        fastIdx++;
                    }
                }
                slowIdx++;
                fastIdx++;
            }
        }
    }
}
