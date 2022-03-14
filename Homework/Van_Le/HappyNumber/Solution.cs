namespace HappyNumber
{
    public static class HappyNumber
    {
        public static bool IsHappy(int n)
        {
            List<int> usedNumbers = new List<int>();
            List<int> digits = new List<int>();
            int result = n;

            while (result != 1)
            {
                usedNumbers.Add(result);
                while (result != 0)
                {
                    digits.Add(result % 10);
                    result /= 10;
                }
                foreach (int digit in digits)
                {
                    result += digit * digit;
                }
                if (usedNumbers.Contains(result))
                {
                    return false;
                }
                digits.Clear();
            }

            return true;
        }
    }
}
