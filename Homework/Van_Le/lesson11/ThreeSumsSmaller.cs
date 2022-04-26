namespace LeetCodeSolutions
{

    /// <summary>
    /// 
    /// First, to make it easy to use two pointers efficiently, this array needs to be sorted.
    /// 
    /// Use two pointers with left one which points to the first item of the array
    /// and the right one which points to the last item of the array.
    /// Another pointer will be initialized next to the left one.
    /// Try to make a comparison such that
    /// nums[left] + nums[right] + nums[pivot] < target;
    /// If this formular is correct then keep the left and pivot position,
    /// the remaining pointer will be satisfied with the condition.
    /// If this formular is not correct, then move the right pointer to the left
    /// and still try to make the condition like the old one.
    /// 
    /// Also, to make the code simply just represents two pointers such as left and
    /// right one only.
    /// Take the first formular as an example, how to simplify it?
    /// It is similar as this formular
    /// nums[left] + nums[right] < target - nums[pivot]
    /// Do the calculation just like the first one and make the script just like the explaination
    /// 
    /// </summary>
    
    public class ThreeSumsSmaller
    {
        public int ThreeSumSmaller(int[] nums, int target)
        {
            Array.Sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.Length - 2; i++)
            {
                sum += TwoSumSmaller(nums, i+1, target - nums[i]);
            }
            return sum;
        }

        private int TwoSumSmaller(int[] nums, int startIndex, int target)
        {
            int sum = 0;
            int left = startIndex;
            int right = nums.Length - 1;
            while (left < right)
            {
                if(nums[left] + nums[right] < target)
                {
                    sum += right - left;
                    left++;
                }
                else
                {
                    right--;
                }
            }
            return sum;
        }
    }
}
