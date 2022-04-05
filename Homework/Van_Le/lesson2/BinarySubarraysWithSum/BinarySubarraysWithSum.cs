namespace LeetCodeSolutions
{
    public static class BinarySubarraysWithSum
    {
        public static int NumSubarraysWithSum(int[] nums, int goal)
        {
            int length = nums.Length;
            int[] prefixSum = new int[length + 1];

            for (var i = 0; i < length; i++)
            {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }

            Dictionary<int, int> count = new Dictionary<int, int>();
            var answer = 0;
            foreach (var pre in prefixSum)
            {
                answer += count.GetValueOrDefault(pre, 0);
                count[pre + goal] = count.GetValueOrDefault(pre + goal, 0) + 1;
            }

            return answer;
        }
    }
}
