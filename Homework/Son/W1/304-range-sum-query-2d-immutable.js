class NumMatrix {
    constructor(matrix){
        this.matrix = matrix;
        this.cache = [];
        this.preCompute();
    }

    preCompute(){
        for (let row = 0; row < this.matrix.length; row++) {
            this.cache[row] = [];
            for (let col = 0; col < this.matrix[0].length; col++) {
                let prevCol = col > 0 ? this.cache[row][col-1] : 0;
                let prevRow = row > 0 ? this.cache[row-1][col] : 0;
                let prevCache = row > 0 && col > 0 ? this.cache[row-1][col-1] : 0;
                let sum = this.matrix[row][col] + prevCol + prevRow - prevCache;
                this.cache[row].push(sum)
            }
        }
    }

    sumRegion(row1, col1, row2, col2){

        let totalArea = this.cache[row2][col2];
        let topArea = row1 > 0 ? this.cache[row1-1][col2] : 0;
        let sideArea = col1 > 0 ? this.cache[row2][col1-1] : 0;
        let cornerArea = row1 > 0 && col1 > 0 ? this.cache[row1-1][col1-1] : 0;

        return totalArea - topArea - sideArea + cornerArea;

    }
}

// https://leetcode.com/problems/range-sum-query-2d-immutable/