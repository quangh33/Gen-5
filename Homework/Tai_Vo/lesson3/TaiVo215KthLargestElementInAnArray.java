package lesson3;

/**
 * @author taivt
 * @link https://leetcode.com/problems/kth-largest-element-in-an-array/
 * @since 2022/03/22 21:43:58
 */
public class TaiVo215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 8, 2, 1, 5, 6, 4}, 2));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, k);
        }

        private int quickSelect(int[] nums, int left, int right, int k) {
            if (left == right) {
                return nums[left];
            }
            int pivotIdx = partition(nums, left, right);
            if (pivotIdx == k - 1) {
                return nums[pivotIdx];
            } else if (pivotIdx < k - 1) {
                return quickSelect(nums, pivotIdx + 1, right, k);
            } else {
                return quickSelect(nums, left, pivotIdx - 1, k);
            }
        }

        private int partition(int[] nums, int left, int right) {
            int pivotValue = nums[right];
            int boundary = left;
            for (int i = left; i < right; i++) {
                if (nums[i] > pivotValue) {
                    swap(nums, i, boundary);
                    boundary++;
                }
            }
            swap(nums, boundary, right);
            return boundary;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
