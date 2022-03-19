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

        int[][] numMatrix2 = new int[][]{
                {-4, -5}
        };
        System.out.println("0, 0, 0, 0 => " + new NumMatrix(numMatrix2).sumRegion(0, 0, 0, 0));
        System.out.println("0, 0, 0, 1 => " + new NumMatrix(numMatrix2).sumRegion(0, 0, 0, 1));
        System.out.println("0, 1, 0, 1 => " + new NumMatrix(numMatrix2).sumRegion(0, 1, 0, 1));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class NumMatrix {
        private final int[][] prefixSums;

        public NumMatrix(int[][] matrix) {
            int height = matrix.length;
            int width = matrix[0].length;
            prefixSums = new int[height + 1][width + 1];
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width; j++) {
                    prefixSums[i][j] = prefixSums[i][j - 1] - prefixSums[i - 1][j - 1] + matrix[i - 1][j - 1] + prefixSums[i - 1][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSums[row2 + 1][col2 + 1] - prefixSums[row2 + 1][col1] - prefixSums[row1][col2 + 1] + prefixSums[row1][col1];
        }
    }
}
