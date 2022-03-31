using System;
using System.Collections.Generic;

namespace ContainsDuplicateII
{
    public class ContainsDuplicateII
    {
        public bool ContainsNearbyDuplicate(int[] nums, int k)
        {
            int legnth = nums.Length;
            if (legnth < 2)
                return false;

            Dictionary<int, int> dic = new Dictionary<int, int>();

            for (int i = 0; i < legnth; i++)
            {
                if (dic.ContainsKey(nums[i]))
                {
                    if (Math.Abs(dic[nums[i]] - i) <= k)
                        return true;
                }

                dic[nums[i]] = i;
            }

            return false;
        }
    }
}
