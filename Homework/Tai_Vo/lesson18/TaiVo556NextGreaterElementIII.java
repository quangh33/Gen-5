package lesson18;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/next-greater-element-iii/
 * @since 2022/06/06 23:46:01
 */
public class TaiVo556NextGreaterElementIII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(12));
        System.out.println(solution.nextGreaterElement(21));
        System.out.println(solution.nextGreaterElement(26387541));
    }

    // n: the length of the integer
    // Space Complexity: O(n)
    // Time Complexity: O(nlog(n))
    private static class Solution {
        public int nextGreaterElement(int n) {
            char[] digits = String.valueOf(n).toCharArray();
            int pivotIdx = -1;
            for (int i = digits.length - 1; i > 0; i--) {
                if (digits[i - 1] < digits[i]) {
                    pivotIdx = i - 1;
                    break;
                }
            }

            if (pivotIdx == -1) {
                return -1;
            }

            int targetIdx = -1;
            for (int i = digits.length - 1; i > pivotIdx; i--) {
                if (digits[i] > digits[pivotIdx]) {
                    targetIdx = i;
                    break;
                }
            }

            char temp = digits[pivotIdx];
            digits[pivotIdx] = digits[targetIdx];
            digits[targetIdx] = temp;

            Arrays.sort(digits, pivotIdx + 1, digits.length);
            long result = Long.parseLong(String.valueOf(digits));
            return result <= Integer.MAX_VALUE ? (int) result : -1;
        }
    }
}
