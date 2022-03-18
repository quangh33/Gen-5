/**
 * @param {number[][]} matrix
 */
var NumMatrix = function(matrix) {
    this.matrix = matrix

    const colLen = matrix[0].length
    const rowLen = matrix.length
    const dp = []

    for (let row = 0; row < rowLen + 1; row++) {
        dp.push([])
        for (let col = 0; col < colLen + 1; col++) {
            if (row === 0 || col === 0) {
                dp[row][col] = 0
            } else {
                dp[row][col] = dp[row][col - 1] + dp[row - 1][col] + matrix[row - 1][col - 1] - dp[row - 1][col - 1];
            }
        }
    }
    this.dp = dp
};

/** 
 * @param {number} row1 
 * @param {number} col1 
 * @param {number} row2 
 * @param {number} col2
 * @return {number}
 */
NumMatrix.prototype.sumRegion = function(row1, col1, row2, col2) {
    return this.dp[row2 + 1][col2 + 1] - this.dp[row1][col2 + 1] - this.dp[row2 + 1][col1] + this.dp[row1][col1] 
};
