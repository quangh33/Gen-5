namespace HappyNumber
{
    public static class HappyNumber
    {
        public static bool IsHappy(int n)
        {
            int slowRunner = n;
            int fastRunner = GetNext(n);
            while (fastRunner != 1 && slowRunner != fastRunner)
            {
                slowRunner = GetNext(slowRunner);
                fastRunner = GetNext(GetNext(fastRunner));
            }
            return fastRunner == 1;
        }
        private static int GetNext(int n)
        {
            int totalSum = 0;
            while (n > 0)
            {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }
    }
}
