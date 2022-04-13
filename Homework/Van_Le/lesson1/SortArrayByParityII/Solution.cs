namespace SortArrayByParityII
{
    public static class Solution
    {
        public static int[] SortArrayByParityII(int[] nums)
        {
            int i = 0, odd = nums.Length - 1, even = nums.Length - 2;

            while (!(i > odd || i > even))
                if (i % 2 == 0)
                {
                    if (nums[i] % 2 != 0)
                    {
                        Swap(ref nums[i], ref nums[odd]);
                        odd -= 2;
                    }
                    else i++;
                }
                else
                {
                    if (nums[i] % 2 == 0)
                    {
                        Swap(ref nums[i], ref nums[even]);
                        even -= 2;
                    }
                    else i++;
                }
            return nums;
        }

        private static void Swap(ref int source, ref int dest)
        {
            int temp = dest;
            dest = source;
            source = temp;
        }
    }
}
