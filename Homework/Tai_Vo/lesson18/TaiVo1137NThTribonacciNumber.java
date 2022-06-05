package lesson18;

/**
 * @author taivt
 * @link https://leetcode.com/problems/n-th-tribonacci-number/
 * @since 2022/06/05 23:09:48
 */
public class TaiVo1137NThTribonacciNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tribonacci(3));
        System.out.println(solution.tribonacci(4));
        System.out.println(solution.tribonacci(25));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            }
            int i0 = 0;
            int i1 = 1;
            int i2 = 1;
            for (int i = 3; i <= n; i++) {
                int temp = i2;
                i2 = i0 + i1 + i2;
                i0 = i1;
                i1 = temp;
            }
            return i2;
        }
    }
}
