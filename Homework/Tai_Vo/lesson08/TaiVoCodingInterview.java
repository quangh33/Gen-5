package lesson08;

public class TaiVoCodingInterview {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(1123456789));
//        System.out.println(solution.reverse(Integer.MAX_VALUE));
//        System.out.println(solution.reverse(Integer.MIN_VALUE));
    }

    private static class Solution {
        public int reverse(int x) {
            long reversedNum = 0;
            while (x != 0) {
                int remainder = x % 10;
                reversedNum = reversedNum * 10 + remainder;
                if (reversedNum > Integer.MAX_VALUE) {
                    return 0;
                }
                x = x / 10;
            }
            return (int) reversedNum;
        }
    }
}
