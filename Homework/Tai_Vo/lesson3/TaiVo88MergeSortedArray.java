package lesson3;

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
        new Solution().merge(nums1, nums1.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    private static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
//            int cur1 = 0;
//            int cur2 = 0;
//            int unsortedIdx = 0;
//
//            while (cur1 < (m + n) && (cur2 < n || unsortedIdx < n)) {
//                if (cur1 >= m) {
//                    if (cur2 < n && nums2[cur2] < nums2[unsortedIdx]) {
//                        nums1[cur1] = nums2[cur2];
//                        cur2++;
//                    } else if (unsortedIdx < n) {
//                        nums1[cur1] = nums2[unsortedIdx];
//                        unsortedIdx++;
//                    }
//                    cur1++;
//                    continue;
//                }
//                if (nums1[cur1] <= nums2[cur2]) {
//                    cur1++;
//                    continue;
//                }
//                if (nums1[cur1] > nums2[cur2]) {
//                    if (nums2[cur2] < nums2[unsortedIdx] || cur2 == unsortedIdx) {
//                        swap(nums1, cur1, nums2, cur2);
//                        cur2++;
//                    } else {
//                        swap(nums1, cur1, nums2, unsortedIdx);
//                        unsortedIdx++;
//                    }
//                    cur1++;
//                }
//            }
        }

        private void swap(int[] nums1, int idx1, int[] nums2, int idx2) {
            int temp = nums1[idx1];
            nums1[idx1] = nums2[idx2];
            nums2[idx2] = temp;
        }
    }
}
