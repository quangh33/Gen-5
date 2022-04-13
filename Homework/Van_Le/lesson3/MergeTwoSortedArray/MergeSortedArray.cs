namespace MergeSortedArray
{
    public static class MergeSortedArray
    {
        public static void Merge(int[] nums1, int m, int[] nums2, int n)
        {
            int i = m - 1;
            int j = n - 1;
            for (int k = nums1.Length - 1; k >= 0; k--)
            {
                if (j < 0)
                {
                    break;
                }
                if (i >= 0 && nums1[i] > nums2[j])
                {
                    nums1[k] = nums1[i--];
                }
                else
                {
                    nums1[k] = nums2[j--];
                }
            }
        }
    }
}
