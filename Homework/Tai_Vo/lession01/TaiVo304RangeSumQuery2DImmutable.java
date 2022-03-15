package lession01;

/**
 * @author taivt
 * @link https://leetcode.com/problems/range-sum-query-2d-immutable/
 * @since 2022/03/15 19:16:50
 */
public class TaiVo304RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        int[][] numMatrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        System.out.println("2, 1, 4, 3 => " + new NumMatrix(numMatrix).sumRegion(2, 1, 4, 3));
        System.out.println("1, 1, 2, 2 => " + new NumMatrix(numMatrix).sumRegion(1, 1, 2, 2));
        System.out.println("1, 2, 2, 4 => " + new NumMatrix(numMatrix).sumRegion(1, 2, 2, 4));
    }

    private static class NumMatrix {
        private final int[][] prefixSums;

        public NumMatrix(int[][] matrix) {
            prefixSums = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix.length; j++) {
                    prefixSums[i][j] = prefixSums[i][j - 1] - prefixSums[i - 1][j - 1] + matrix[i - 1][j - 1] + prefixSums[i - 1][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // Space Complexity: O(n)
            // Time Complexity: O(1)
            return prefixSums[row2 + 1][col2 + 1] - prefixSums[row2 + 1][col1] - prefixSums[row1][col2 + 1] + prefixSums[row1][col1];
        }
    }
}
