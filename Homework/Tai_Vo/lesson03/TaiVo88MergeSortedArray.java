package lesson03;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/merge-sorted-array/
 * @since 2022/03/21 21:07:43
 */
public class TaiVo88MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 9, 10, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 4;
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    // Space Complexity: O(m)
    // Time Complexity: O(m + n)
    private static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] nums3 = new int[m];
            // copy nums1 to nums3
            System.arraycopy(nums1, 0, nums3, 0, nums3.length);

            int cur1 = 0;
            int cur2 = 0;
            int cur3 = 0;

            while (cur1 < m + n) {
                if (cur3 >= m || (cur2 < n && nums2[cur2] < nums3[cur3])) {
                    nums1[cur1] = nums2[cur2];
                    cur2++;
                } else {
                    nums1[cur1] = nums3[cur3];
                    cur3++;
                }
                cur1++;
            }
        }
    }
}
