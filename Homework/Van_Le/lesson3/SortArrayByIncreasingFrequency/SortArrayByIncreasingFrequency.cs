using System;
using System.Collections.Generic;

namespace SingleNumber
{
    public class SortArrayByIncreasingFrequency
    {
        public int[] FrequencySort(int[] nums)
        {
            Dictionary<int, int> frequency = new Dictionary<int, int>();

            foreach (int val in nums)
            {
                if (!frequency.ContainsKey(val))
                {
                    frequency.Add(val, 1000 - val);
                }
                else
                {
                    frequency[val] += 1000;
                }
            }

            Array.Sort(nums, (a, b) => frequency[a] - frequency[b]);

            return nums;
        }
    }
}
