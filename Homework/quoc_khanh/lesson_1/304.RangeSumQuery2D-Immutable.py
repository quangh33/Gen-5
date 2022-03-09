from typing import List


class NumMatrix:
    def calculatePrefixSum(self):
        for row in range(self.rows):
            for col in range(self.cols):
                currentNum = self.matrix[row][col]
                topSum = 0 if row == 0 else self.prefixSums[row - 1][col]
                leftSum = 0 if col == 0 else self.prefixSums[row][col - 1]
                topLeftSum = 0 if col == 0 or row == 0 else self.prefixSums[row - 1][col - 1]
                self.prefixSums[row][col] = currentNum + topSum + leftSum - topLeftSum

    def __init__(self, matrix: List[List[int]]):
        self.rows = len(matrix)
        self.cols = len(matrix[0])
        self.matrix = matrix
        self.prefixSums = [[0] * self.cols for row in range(self.rows)]
        self.calculatePrefixSum()
        

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        bottomRightSum = self.prefixSums[row2][col2]
        bottomLeftSum = 0 if col1 == 0 else self.prefixSums[row2][col1 - 1]
        topRightSum = 0 if row1 == 0 else self.prefixSums[row1 - 1][col2]
        topLeftSum = 0 if row1 == 0 or col1 == 0 else self.prefixSums[row1 - 1][col1 - 1]
        return bottomRightSum - bottomLeftSum - topRightSum + topLeftSum

matrix = [
    [3, 0, 1, 4, 2],
    [5, 6, 3, 2, 1],
    [1, 2, 0, 1, 5],
    [4, 1, 0, 1, 7],
    [1, 0, 3, 0, 5]
]
s = NumMatrix(matrix)
# print(s.sumRegion(2, 1, 4, 3) == 8)
# print(s.sumRegion(1, 1, 2, 2) == 11)
# print(s.sumRegion(1, 2, 2, 4) == 12)
# print(s.sumRegion(1, 1, 1, 1) == 8)
# print(s.sumRegion(0, 0, 0, 0) == 8)
# print(s.sumRegion(0, 0, 4, 5) == 8)
print(s.sumRegion(1, 0, 2, 3) == 20)
print(s.sumRegion(0, 1, 2, 3) == 19)