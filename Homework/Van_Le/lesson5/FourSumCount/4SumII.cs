using System.Collections.Generic;

namespace _4SumII
{
    public static class _4SumII
    {
        public static int FourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4)
        {
            int length = nums1.Length, tuples = 0;
            Dictionary<int, int> dict1 = new Dictionary<int, int>();
            Dictionary<int, int> dict2 = new Dictionary<int, int>();

            for (int i = 0; i < length; i++)
            {
                for (int j = 0; j < length; j++)
                {
                    int dict1_key = nums1[i] + nums2[j];

                    if (dict1.ContainsKey(dict1_key))
                        dict1[dict1_key]++;
                    else
                        dict1.Add(dict1_key, 1);

                    int dict2_key = nums3[i] + nums4[j];

                    if (dict2.ContainsKey(dict2_key))
                        dict2[dict2_key]++;
                    else
                        dict2.Add(dict2_key, 1);
                }
            }

            foreach (int key in dict1.Keys)
            {
                if (dict2.ContainsKey(-key))
                    tuples += dict1[key] * dict2[-key];
            }

            return tuples;
        }
    }
}
