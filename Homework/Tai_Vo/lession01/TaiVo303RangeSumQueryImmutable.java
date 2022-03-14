package lession01;

/**
 * @author taivt
 * @since 2022/03/14 20:54:33
 * @link https://leetcode.com/problems/range-sum-query-immutable/
 */
public class TaiVo303RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println("Sum from 0 -> 2 = " + numArray.sumRange(0, 2));
        System.out.println("Sum from 2 -> 5 = " + numArray.sumRange(2, 5));
        System.out.println("Sum from 0 -> 5 = " + numArray.sumRange(0, 5));
    }

    private static class NumArray {
        private final int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            // Space Complexity: O(n)
            // Time Complexity: O(1)
            if (left == 0) {
                return prefixSum[right];
            }
            return prefixSum[right] - prefixSum[left - 1];
        }
    }
}
