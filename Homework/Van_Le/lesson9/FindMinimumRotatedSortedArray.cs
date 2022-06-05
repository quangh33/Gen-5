namespace LeetCodeSolutions
{
    public class FindMinimumRotatedSortedArray
    {
        public int FindMin(int[] nums)
        {
            if(nums.Length == 1) return nums[0];
            bool isSortedLeft = false;
            int left = 0;
            int right = nums.Length - 1;
            int mid = left + (right - left) / 2;

            if (nums[left] <= nums[mid])
            {
                isSortedLeft = true;
            }

            if (isSortedLeft)
            {
                while (nums[mid] <= nums[mid + 1])
                {
                    mid++;
                    if (mid == right) return nums[left];
                }
                return nums[mid + 1];
            }
            while (nums[mid] >= nums[mid - 1]) mid--;
            return nums[mid];
        }
    }
}
