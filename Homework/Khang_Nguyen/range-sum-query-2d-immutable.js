/**
 * @param {number[][]} matrix
 */
var NumMatrix = function(matrix) {
    this.matrix = matrix

    const colLen = matrix[0].length
    const rowLen = matrix.length
    const dp = []

    for (let row = 0; row < rowLen; row++) {
        dp.push([])
        for (let col = 0; col < colLen; col++) {
            if (row - 1 >= 0 && col - 1 >= 0) {
               dp[row][col] = dp[row - 1][col] + dp[row][col - 1] - dp[row - 1][col -1] + matrix[row][col]
            } else if (row - 1 >= 0) {
               dp[row][col] = dp[row - 1][col] + matrix[row][col]
            } else if (col - 1 >= 0) {
               dp[row][col] = dp[row][col - 1] + matrix[row][col]
            } else {
               dp[row][col] = matrix[row][col]
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
    const upperLeft = (row1 >= 1) && (col1 >= 1) ? this.dp[row1 - 1][col1 -1] : 0 
    const upperRight = (row1 >= 1) ? this.dp[row1 - 1][col2] : 0 
    const lowerLeft = (col1 >= 1) ? this.dp[row2][col1 -1] : 0 
    return this.dp[row2][col2] - upperRight - lowerLeft + upperLeft
};
