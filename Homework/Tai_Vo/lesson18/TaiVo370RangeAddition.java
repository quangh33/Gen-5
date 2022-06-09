package lesson18;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/range-addition/
 * @since 2022/05/31 14:14:59
 */
public class TaiVo370RangeAddition {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}})));
        System.out.println(Arrays.toString(solution.getModifiedArray(10, new int[][]{{2, 4, 6}, {5, 6, 8}, {1, 9, -4}})));
    }

    // n: length, m: updates.length
    // Space Complexity: O(n)
    // Time Complexity: O(m + n)
    private static class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] result = new int[length];
            for (int[] range : updates) {
                int start = range[0];
                int end = range[1];
                int value = range[2];
                result[start] += value;
                if (end < length - 1) {
                    result[end + 1] -= value;
                }
            }

            for (int i = 1; i < length; i++) {
                result[i] += result[i - 1];
            }

            return result;
        }
    }
}
