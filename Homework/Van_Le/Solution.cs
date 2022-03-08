using System.Collections.Generic;

namespace ContainsCode
{
    public static class Solution
    {
        public static bool ContainsDuplicate(int[] nums)
        {
            Dictionary<int, int> hashmap = new Dictionary<int, int>();
            for (int i = 0; i < nums.Length; i++)
            {
                if (hashmap.ContainsKey(nums[i]))
                {
                    return true;
                }
                hashmap[nums[i]] = i;
            }
            return false;
        }
    }
}
