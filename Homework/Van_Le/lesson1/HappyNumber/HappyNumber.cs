namespace HappyNumber
{
    public static class HappyNumber
    {
        public static bool IsHappy(int number)
        {
            int slowRunner = number;
            int fastRunner = GetNext(number);
            while (fastRunner != 1 && slowRunner != fastRunner)
            {
                slowRunner = GetNext(slowRunner);
                fastRunner = GetNext(GetNext(fastRunner));
            }
            return fastRunner == 1;
        }
        private static int GetNext(int number)
        {
            int totalSum = 0;
            while (number > 0)
            {
                int digit = number % 10;
                number /= 10;
                totalSum += digit * digit;
            }
            return totalSum;
        }
    }
}
