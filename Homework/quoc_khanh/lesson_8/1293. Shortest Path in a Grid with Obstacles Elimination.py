from queue import Queue
from typing import List

turns = [
    (-1, 0), # UP
    ( 0, 1), # RIGHT
    ( 1, 0), # DOWN
    ( 0,-1), # LEFT
]

VISITED = -1
MAX_PATH = 40 * 40 + 1

class Solution:
    def __init__(self) -> None:
        self.grid = []
        self.rows = 0
        self.cols = 0

    def isCoordinatorValid(self, row, col: int) -> bool:
        validCoordinator = row >= 0 and col >= 0 and row < self.rows and col < self.cols
        return validCoordinator and self.grid[row][col] != VISITED

    def containsObtacle(self, row, col: int) -> bool:
        return self.grid[row][col] == 1
    
    def reachedTarget(self, row, col: int) -> bool:
        return row == self.rows - 1 and col == self.cols - 1

    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        self.grid = grid
        self.rows = len(grid)
        self.cols = len(grid[0])
        queue = Queue()
        queue.put((0,0,0,k))
        grid[0][0] = VISITED
        while not queue.empty():
            row, col, pathLength, currK = queue.get()
            if self.reachedTarget(row, col):
                return pathLength
            for x, y in turns:
                nextRow = row + x
                nextCol = col + y
                if self.isCoordinatorValid(nextRow, nextCol):
                    if self.containsObtacle(nextRow, nextCol):
                        if currK > 0:
                            queue.put((nextRow, nextCol, pathLength + 1, currK - 1))
                            grid[nextRow][nextCol] = VISITED
                    else:
                        queue.put((nextRow, nextCol, pathLength + 1, currK))
                        grid[nextRow][nextCol] = VISITED
        return -1

s = Solution()
print(s.shortestPath([[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], 1) == 6)
print(s.shortestPath([[0,1,1],[1,1,1],[1,0,0]], 1) == -1)
grid = [[0,0,0,0,0,0,0,0,0,0],[0,1,1,1,1,1,1,1,1,0],[0,1,0,0,0,0,0,0,0,0],[0,1,0,1,1,1,1,1,1,1],[0,1,0,0,0,0,0,0,0,0],[0,1,1,1,1,1,1,1,1,0],[0,1,0,0,0,0,0,0,0,0],[0,1,0,1,1,1,1,1,1,1],[0,1,0,1,1,1,1,0,0,0],[0,1,0,0,0,0,0,0,1,0],[0,1,1,1,1,1,1,0,1,0],[0,0,0,0,0,0,0,0,1,0]]
print(s.shortestPath(grid, 1))