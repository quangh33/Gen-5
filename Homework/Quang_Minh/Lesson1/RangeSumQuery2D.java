class RangeSumQuery2D {
        int[][] prefixSum;

        NumMatrix(int[][] matrix) {
            prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i < prefixSum.length; i++) {
                for (int j = 1; j < prefixSum[0].length; j++) {
                    prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] + matrix[i - 1][j - 1] - prefixSum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
        }
}
