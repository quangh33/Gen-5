package lession01;

import java.util.HashSet;

/**
 * @author taivt
 * @link https://leetcode.com/problems/happy-number/
 * @since 2022/03/15 19:02:22
 */
public class TaiVo202HappyNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
        System.out.println(new Solution().isHappy(2));
        System.out.println(new Solution().isHappy(1));
        System.out.println(new Solution().isHappy(1111111));
        System.out.println(new Solution().isHappy(44));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(1)
    private static class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<>();
            do {
                n = sumSquareDigits(n);
                if (set.contains(n)) {
                    return false;
                }
                set.add(n);
            } while (n != 1);

            return true;
        }

        private int sumSquareDigits(int n) {
            int sum = 0;
            while (n > 0) {
                int lastDigit = n % 10;
                sum += lastDigit * lastDigit;   // sum = sum + lastDigit ^ 2
                n /= 10;
            }
            return sum;
        }
    }
}
