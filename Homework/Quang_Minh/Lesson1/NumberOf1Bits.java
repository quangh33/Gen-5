public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int result = 0;
        while (true) {
            if (n == 0) break;
            n = n & (n - 1);
            result++;
        }
        return result;
    }
}
