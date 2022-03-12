/**
 * @param {number[][]} matrix
 */
var NumMatrix = function (matrix) {
  // save range sum from (0, 0) to [i, j]
  this.matrix = [];
  for (let i = 0; i < matrix.length; i++) {
    this.matrix.push([]);
    for (let j = 0; j < matrix[i].length; j++) {
      this.matrix[i].push(
        matrix[i][j] +
          (i ? this.matrix[i - 1][j] : 0) + // add previous upper
          (j ? this.matrix[i][j - 1] : 0) - // add previous left
          (i && j ? this.matrix[i - 1][j - 1] : 0) // minus previous upper left
      );
    }
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
  return (
    this.matrix[row2][col2] -
    (col1 ? this.matrix[row2][col1 - 1] : 0) - // minus left region
    (row1 ? this.matrix[row1 - 1][col2] : 0) + // minus top region
    (col1 && row1 ? this.matrix[row1 - 1][col1 - 1] : 0) // add top left region
  );
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
const matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5],
];
var obj = new NumMatrix(matrix);
let [row1, col1, row2, col2] = [2, 1, 4, 3];
var param_1 = obj.sumRegion(row1, col1, row2, col2);
console.log(obj.matrix, param_1 === 8);
