/**
 * @param {number[][]} matrix
 */
var NumMatrix = function (matrix) {
  this.matrix = matrix;
  this.prefixSum2d = [];
  for (let i = 0; i < matrix.length; i++) {
    let prefixSumRow = [];
    for (let j = 0; j < matrix[0].length; j++) {
      if (j === 0) {
        prefixSumRow[0] = matrix[0][0];
      } else {
        prefixSumRow[j] = prefixSumRow[j - 1] + matrix[i][j];
      }
    }
    this.prefixSum2d.push(prefixSumRow);
  }
};

/**
 * @param {number} row1
 * @param {number} col1
 * @param {number} row2
 * @param {number} col2
 * @return {number}
 */
NumMatrix.prototype.sumRegion = function (row1, col1, row2, col2) {
  let sum = 0;
  for (let i = row1; i <= row2; i++) {
    const prefixSumRow = this.prefixSum2d[i];
    sum += prefixSumRow[col2] - prefixSumRow[col1] + this.matrix[i][col1];
  }
  return sum;
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
