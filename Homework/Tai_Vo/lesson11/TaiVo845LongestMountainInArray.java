package lesson11;

/**
 * @author taivt
 * @link https://leetcode.com/problems/longest-mountain-in-array/
 * @since 2022/05/02 23:07:54
 */
public class TaiVo845LongestMountainInArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(solution.longestMountain(new int[]{2, 2, 2}));
        System.out.println(solution.longestMountain(new int[]{875, 884, 239, 731, 723, 685}));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public int longestMountain(int[] arr) {
            int res = 0;
            int i = 0;
            int length = arr.length;
            while (i < length) {
                int j = i;
                while (j + 1 < length && arr[j + 1] > arr[j]) {
                    j++;
                }
                int k = j;
                while (k + 1 < length && arr[k + 1] < arr[k]) {
                    k++;
                }
                if (i != j && j != k) {
                    res = Math.max(res, k - i + 1);
                }
                if (i != k) {
                    i = k;
                } else {
                    i++;
                }
            }
            return res;
        }
    }
}
