package lesson09;

/**
 * @author taivt
 * @link https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * @since 2022/04/17 22:36:51
 */
public class TaiVo153FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(solution.findMin(new int[]{11, 13, 15, 17}));
        System.out.println(solution.findMin(new int[]{3, 1, 2}));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(log(n))
    private static class Solution {
        public int findMin(int[] nums) {
            int length = nums.length;
            if (nums[0] <= nums[length - 1]) {
                return nums[0];
            }

            int low = 0, high = length - 1;
            int res = nums[0];
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid + 1] < nums[mid]) {
                    return nums[mid + 1];
                } else if (nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                }

                if (nums[mid] >= nums[0]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return res;
        }

    }
}
