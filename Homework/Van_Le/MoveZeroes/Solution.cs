namespace MoveZeroes
{
    public static class MoveZeroes
    {
        public static void MoveZeroes(int[] nums)
        {
            int left = 0;
            int right = 0;
            while (right < nums.Length)
            {

                if (nums[right] != 0)
                {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
                }
                right++;
            }
        }
    }
}
