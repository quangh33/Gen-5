#https://leetcode.com/problems/range-sum-query-2d-immutable/
class NumMatrix:
    def __init__(self, matrix: List[List[int]]):
        m = len(matrix)
        n = len(matrix[0])
        self.prefixSum = [[0]*(n+1) for i in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                self.prefixSum[i][j]=self.prefixSum[i-1][j]+self.prefixSum[i][j-1]-self.prefixSum[i-1][j-1]+matrix[i-1][j-1]
    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return self.prefixSum[row2+1][col2+1]-self.prefixSum[row1][col2+1]-self.prefixSum[row2+1][col1]+self.prefixSum[row1][col1]