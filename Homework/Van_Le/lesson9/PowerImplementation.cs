namespace LeetCodeSolutions
{
    public class PowerImplementation
    {
        public double MyPow(double x, int n)
        {
            if (n == 0) return 1;
            if (n == 1) return x;

            double result = MyPow(x, Math.Abs(n/2));
            result *= result;
            if (n % 2 != 0)
            {
                result *= x;
            }
            return n >= 0 ? result : 1 / (double)result;
        }
    }
}
