using System;

namespace SlidingWindowMax
{
    public class SlidingWindowMax
    {
        public int[] MaxSlidingWindow(int[] nums, int range)
        {
            int length = nums.Length;
            if (length * range == 0)
            {
                return new int[0];
            }
            if (range == 1)
            {
                return nums;
            }

            int[] result = new int[length - range + 1];
            int[] left = new int[length];
            int[] right = new int[length];
            left[0] = nums[0];
            right[length - 1] = nums[length - 1];

            for (int i = 1; i < length; i++)
            {
                if (i % range == 0)
                {
                    left[i] = nums[i];
                }
                else
                {
                    left[i] = Math.Max(left[i - 1], nums[i]);
                }
                int j = length - i - 1;
                if((j+1)%range == 0)
                {
                    right[j]=nums[j];
                }
                else
                {
                    right[j] = Math.Max(right[j + 1], nums[j]);
                }
            }

            for (int i = 0; i < length - range + 1; i++)
            {
                result[i] = Math.Max(right[i], left[i + range - 1]);
            }

            return result;
        }
    }
}
