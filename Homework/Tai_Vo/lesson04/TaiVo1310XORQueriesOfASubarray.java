package lesson04;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/xor-queries-of-a-subarray/
 * @since 2022/03/25 02:36:56
 */
public class TaiVo1310XORQueriesOfASubarray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.xorQueries(arr, queries)));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n + m)
    private static class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] prefixXOR = new int[arr.length + 1];
            for (int i = 1; i <= arr.length; i++) {
                prefixXOR[i] = prefixXOR[i - 1] ^ arr[i - 1];
            }

            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int left = query[0];
                int right = query[1];
                result[i] = prefixXOR[right + 1] ^ prefixXOR[left];
            }
            return result;
        }
    }
}
