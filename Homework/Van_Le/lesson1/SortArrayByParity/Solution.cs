namespace SortArrayByParity
{
    public static class Solution
    {
        public static int[] SortArrayByParity(int[] nums)
        {
            int left = 0, right = 0;
            while (right < nums.Length)
            {
                if(nums[right] % 2 == 0)
                {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
                }
                right++;
            }
            return nums;
        }
    }
}
