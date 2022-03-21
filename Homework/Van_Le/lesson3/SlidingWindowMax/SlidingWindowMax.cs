using System;

namespace SlidingWindowMax
{
    public class SlidingWindowMax
    {
        public int[] MaxSlidingWindow(int[] nums, int range)
        {
            int length = nums.Length;
            if (length == 0)
            {
                return new int[0];
            }

            int[] result = new int[length - range + 1];

            int max = 0;
            for (int i = 1; i < range; i++)
            {
                if (nums[i] >= nums[max])
                    max = i;
            }

            if (range >= length)
            {
                Array.Fill(result, nums[max]);
                return result;
            }
            result[0] = nums[max];
            for (int i = range; i < length; i++)
            {
                if (nums[i] >= nums[max])
                {
                    max = i;
                    result[i - range + 1] = nums[max];
                }
                else if (i - range == max)
                {
                    max = i - range + 1;
                    for (int j = i - range + 2; j <= i; j++)
                    {
                        if (nums[j] >= nums[max])
                            max = j;
                    }
                    result[i - range + 1] = nums[max];
                }
                else
                {
                    result[i - range + 1] = nums[max];
                }
            }
            return result;
        }
    }
}
