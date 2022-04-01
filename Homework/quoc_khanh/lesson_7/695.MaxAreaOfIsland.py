from turtle import width
from typing import List

WATER = 0
LAND = 1
VISITED = 2
turns = [
    [-1,  0],  # UP
    [ 1,  0],  # DOWN
    [ 0, -1],  # LEFT
    [ 0,  1],  # RIGHT
]

def isCellVisted(grid: List[List[int]], x: int, y: int) -> bool:
    return grid[x][y] == VISITED

def isLand(grid: List[List[int]], x: int, y: int) -> bool:
    return grid[x][y] == LAND

def markVisited(grid: List[List[int]], row: int, col: int):
        grid[row][col] = VISITED

class Solution:
    def __init__(self) -> None:
        self.rows = 0
        self.cols = 0

    def isCellValid(self, rowIdx: int, colIdx: int) -> bool:
        return  rowIdx >=0 and \
                colIdx >= 0 and \
                rowIdx < self.rows and \
                colIdx < self.cols


    def discover(self, grid: List[List[int]], row: int, col: int):
        area = 0
        if not isCellVisted(grid, row, col) and isLand(grid, row, col):
            markVisited(grid, row, col)
            area += 1
            for x, y in turns:
                nextRow = row + x
                nextCol = col + y
                if self.isCellValid(nextRow, nextCol):
                    area += self.discover(grid, nextRow, nextCol)
        else:
            markVisited(grid, row, col)

        return area

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        self.rows = rows = len(grid)
        self.cols = cols = len(grid[0])
        maxArea = 0
        for row in range(rows):
            for col in range(cols):
                area = self.discover(grid, row, col)
                maxArea = max(area, maxArea)
        return maxArea

s = Solution()
grid = [
    [0,0,1,0,0,0,0,1,0,0,0,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,1,1,0,1,0,0,0,0,0,0,0,0],
    [0,1,0,0,1,1,0,0,1,0,1,0,0],
    [0,1,0,0,1,1,0,0,1,1,1,0,0],
    [0,0,0,0,0,0,0,0,0,0,1,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,0,0,0,0,0,0,1,1,0,0,0,0]
]
print(s.maxAreaOfIsland(grid) == 6)

grid = [[0,0,0,0,0,0,0,0]]
print(s.maxAreaOfIsland(grid) == 0)
