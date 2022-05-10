namespace LeetCodeSolutions
{
    public class LongestMountainArray
    {

        /// <summary>
        /// For this problem, it's important to determine the left-boundary mountain before peak and
        /// the other right-boundary one after peak. Try to record the candidate after traverse 
        /// the mountain and result the maximum candidate.
        /// </summary>
        /// <param name="arr"></param>
        /// <returns></returns>

        public int LongestMountain(int[] arr)
        {
            int size = arr.Length;
            int slow = 0;
            int result = 0;

            while (slow < size)
            {
                int fast = slow;
                if (fast + 1 < size && arr[fast] < arr[fast + 1])
                {
                    while (fast + 1 < size && arr[fast] < arr[fast + 1])
                    {
                        fast++;
                    }
                    if (fast + 1 < size && arr[fast] > arr[fast + 1])
                    {
                        while (fast + 1 < size && arr[fast] > arr[fast + 1])
                        {
                            fast++;
                        }
                        result = Math.Max(result, fast - slow + 1);
                    }
                }
                slow = Math.Max(fast, slow + 1);
            }
            return result;
        }
    }
}
