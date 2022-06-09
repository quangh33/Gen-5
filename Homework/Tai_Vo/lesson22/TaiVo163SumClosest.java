package lesson22;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/3sum-closest/
 * @since 2022/06/07 20:37:37
 */
public class TaiVo163SumClosest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(solution.threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    // n: nums.length
    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int minGap = Integer.MAX_VALUE;
            int result = -1;
            for (int i = 0; i < nums.length - 2; i++) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    int curGap = Math.abs(target - sum);
                    if (curGap < minGap) {
                        minGap = curGap;
                        result = sum;
                    }

                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        break;
                    }
                }
            }

            return result;
        }
    }
}
