namespace MaximumSubArray
{
    public static class MaximumSubArray
    {
        public static int MaxSubArray(int[] nums)
        {
            int maxSum = int.MinValue, currSum = 0;
            for (int i = 0; i < nums.Length; i++)
            {
                currSum += nums[i];
                if (currSum > maxSum) maxSum = currSum;
                if (currSum < 0) currSum = 0;
            }
            return maxSum;
        }
    }
}
