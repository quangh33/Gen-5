using System.Collections.Generic;

namespace ContainDuplicate
{
    public static class Duplicate
    {
        public static bool ContainsDuplicate(int[] nums)
        {
            Dictionary<int, int> myMap = new Dictionary<int, int> ();
            for (int i = 0; i < nums.Length; i++)
            {
                if (myMap.ContainsKey(nums[i]))
                {
                    return true;
                }
                myMap[nums[i]] = i;
            }
            return false;
        }
    }
}
