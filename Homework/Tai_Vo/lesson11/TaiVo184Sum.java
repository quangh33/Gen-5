package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author taivt
 * @link https://leetcode.com/problems/4sum/
 * @since 2022/05/04 21:35:38
 */
public class TaiVo184Sum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n ^ 3)
    private static class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3 && nums[i] <= target; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    // ignore duplicate triplets
                    continue;
                }
                threeSum(nums, i, target - nums[i], result);
            }
            return result;
        }

        public void threeSum(int[] nums, int curI, int target, List<List<Integer>> result) {
            for (int j = curI + 1; j < nums.length - 2 && nums[j] <= target; j++) {
                if (j > 0 && nums[j - 1] == nums[j]) {
                    // ignore duplicate triplets
                    continue;
                }
                twoSum(nums, curI, j, target - nums[j], result);
            }
        }

        private void twoSum(int[] nums, int curI, int curJ, int target, List<List<Integer>> result) {
            int l = curJ + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[curI] + nums[curJ] + nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    result.add(List.of(nums[curI], nums[curJ], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l - 1] == nums[l]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
    }
}
