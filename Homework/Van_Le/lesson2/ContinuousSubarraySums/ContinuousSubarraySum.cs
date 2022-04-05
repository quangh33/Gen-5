namespace LeetCodeSolutions
{
    public static class ContinuousSubarraySum
    {
        public static bool CheckSubarraySum(int[] nums, int k)
        {
            Dictionary<int, int> map = new Dictionary<int, int>();

            map[0] = -1;

            var sum = 0;

            for(var i = 0; i< nums.Length; i++)
            {
                sum += nums[i];
                var r = sum % k;

                if (!map.ContainsKey(r))
                {
                    map[r] = i;
                }
                else
                {
                    var count  = i - map[r];
                    if(count >= 2)
                    {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
