package lesson09;

/**
 * @author taivt
 * @link https://leetcode.com/problems/powx-n/
 * @since 2022/04/17 20:51:22
 */
public class TaiVo50PowXN {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, 10));
        System.out.println(solution.myPow(2.1, 3));
        System.out.println(solution.myPow(2, -2));
        System.out.println(solution.myPow(2, -2147483648));
    }

    // Space Complexity: O(log(n))
    // Time Complexity: O(log(n))
    private static class Solution {
        public double myPow(double x, int n) {
            if (n < 0) {
                x = 1 / x;
                n = -n;
            }
            return pow(x, n);
        }

        private double pow(double x, int n) {
            if (n == 0) {
                return 1;
            } else if (n == 1) {
                return x;
            }
            double halfPow = pow(x, n / 2);
            if (n % 2 == 0) {
                return halfPow * halfPow;
            } else {
                return halfPow * halfPow * x;
            }
        }
    }
}
