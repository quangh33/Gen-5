package utils;

import java.util.Arrays;
import java.util.List;

/**
 * @author taivt
 * @since 2022/04/19 21:29:20
 */
public class TaiVo153Sum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));

            int l = 0;
            int r = nums.length - 1;
            while (l + 2 <= r) {
                if (nums[l] + nums[l + 1] + nums[r] == 0) {
                    System.out.printf("%s %s %s%n", nums[l], nums[l + 1], nums[r]);
                    l++;
                    continue;
                } else if (nums[l] + nums[r] + nums[r - 1] == 0) {
                    System.out.printf("%s %s %s%n", nums[l], nums[r], nums[r - 1]);
                    r--;
                    continue;
                }

                if (nums[l] < nums[r] + nums[r - 1]) {
                    l++;
                } else if (nums[r] > nums[l] + nums[l + 1]) {
                    r++;
                } else {
                    l++;
                }
            }
            return null;
        }
    }
}
