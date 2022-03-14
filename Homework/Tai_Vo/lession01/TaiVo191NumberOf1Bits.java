package lession01;

/**
 * @author taivt
 * @link https://leetcode.com/problems/number-of-1-bits/
 * @since 2022/03/14 20:37:19
 */
public class TaiVo191NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(String.format("%32s", Integer.toBinaryString(11)).replace(' ', '0'));
        System.out.println(new Solution().hammingWeight(11));
        System.out.println(String.format("%32s", Integer.toBinaryString(128)).replace(' ', '0'));
        System.out.println(new Solution().hammingWeight(128));
        System.out.println(String.format("%32s", Integer.toBinaryString(-3)).replace(' ', '0'));
        System.out.println(new Solution().hammingWeight(-3));
    }

    private static class Solution {
        public int hammingWeight(int n) {
            // Space Complexity: O(1)
            // Time Complexity: O(1)
            int count = 0;
            for (int i = 0; i < 32; i++) {
                boolean isRightMostBit1 = (n | 1) == n;
                if (isRightMostBit1) {
                    count++;
                }
                n >>= 1;
            }
            return count;
        }
    }
}
