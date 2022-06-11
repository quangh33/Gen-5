from typing import List

OBSTACLE = 1

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        if obstacleGrid[0][0] == OBSTACLE:
            return 0
        rows, cols = len(obstacleGrid), len(obstacleGrid[0])
        arr = [[0] * cols for _ in range(rows)]
        for col in range(cols):
            if obstacleGrid[0][col] != OBSTACLE:
                arr[0][col] = 1
            else:
                break
        for row in range(rows):
            if obstacleGrid[row][0] != OBSTACLE:
                arr[row][0] = 1
            else:
                break
        for i in range(1, rows):
            for j in range(1, cols):
                if obstacleGrid[i][j] != OBSTACLE:
                    arr[i][j] = arr[i-1][j] + arr[i][j-1]
        return arr[-1][-1]

s = Solution()
s.uniquePathsWithObstacles([[0,1], [0,0]])
