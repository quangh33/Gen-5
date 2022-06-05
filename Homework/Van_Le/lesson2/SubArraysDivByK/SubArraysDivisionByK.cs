namespace LeetCodeSolutions
{
    public static class SubArraysDivisionByK
    {
        public static int SubarraysDivByK(int[] nums, int k)
        {
            var ans = 0;

            var pre = new int[nums.Length + 1];
            for (var i = 0; i < nums.Length; ++i)
                pre[i + 1] = (pre[i] + nums[i] + k * 10000) % k;

            var pos = new Dictionary<int, int>();
            pos[pre[0]] = 1;

            for (var i = 0; i < nums.Length; ++i)
            {
                if (!pos.ContainsKey(pre[i + 1]))
                    pos[pre[i + 1]] = 0;

                pos[pre[i + 1]]++;
            }

            foreach (var p in pos)
                ans += ((p.Value - 1) * p.Value) / 2;

            return ans;
        }
    }
}
