/**
 * @param {number[][]} matrix
 */
var NumMatrix = function(matrix) {
    this.numMatrix = [];
    for(let i=0;i<matrix.length;i++) {
        this.numMatrix.push(matrix[i])
    }
};

/** 
 * @param {number} row1 
 * @param {number} col1 
 * @param {number} row2 
 * @param {number} col2
 * @return {number}
 */
NumMatrix.prototype.sumRegion = function(row1, col1, row2, col2) {
    if(row1 > row2) {
        let rowTemp = row1;
        row1 = row2;
        row2 = temp;
        let colTemp = col1;
        col1 = col2;
        col2 = colTemp;
    }
    let sum = 0;
    for(let i=row1;i<=row2;i++) {
        for(let j=col1;j<=col2;j++) {
            sum += this.numMatrix[i][j]
        }
    }
    return sum;
};

/** 
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */