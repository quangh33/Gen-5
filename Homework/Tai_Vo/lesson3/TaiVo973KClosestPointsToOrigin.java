package lesson3;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/k-closest-points-to-origin/
 * @since 2022/03/23 20:56:03
 */
public class TaiVo973KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{0, 1}, {1, 0}}, 2)));
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {

        public int[][] kClosest(int[][] points, int k) {
            return quickSelect(points, k);
        }

        private int[][] quickSelect(int[][] points, int k) {
            int left = 0;
            int right = points.length - 1;
            int pivotIdx = points.length;
            while (pivotIdx != k) {
                pivotIdx = partition(points, left, right);
                if (pivotIdx < k) {
                    left = pivotIdx;
                } else {
                    right = pivotIdx - 1;
                }
            }
            return Arrays.copyOf(points, k);
        }

        private int partition(int[][] points, int left, int right) {
            int[] pivot = choosePivot(points, left, right);
            int pivotDist = squaredDistance(pivot);
            while (left < right) {
                if (squaredDistance(points[left]) >= pivotDist) {
                    swap(points, left, right);
                    right--;
                } else {
                    left++;
                }
            }
            if (squaredDistance(points[left]) < pivotDist) {
                left++;
            }
            return left;
        }

        private void swap(int[][] points, int i, int j) {
            int[] temp = points[i];
            points[i] = points[j];
            points[j] = temp;
        }

        private int[] choosePivot(int[][] points, int left, int right) {
            return points[left + (right - left) / 2];
        }

        private int squaredDistance(int[] point) {
            return point[0] * point[0] + point[1] * point[1];
        }
    }
}
