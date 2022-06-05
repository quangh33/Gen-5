from queue import Queue
from typing import List

turns = [
    (-1,  0), # TOP
    (-1,  1), # TOP RIGHT
    (-1, -1), # TOP LEFT
    ( 1,  0), # BOTTOM
    ( 1,  1), # BOTTOM RIGHT
    ( 1, -1), # BOTTOM LEFT
    ( 0, -1), # LEFT
    ( 0,  1), # RIGHT
]

MAX_SIZE = 100
MAX_PATH_LENGTH = MAX_SIZE * MAX_SIZE + 1

class Solution:
    def __init__(self) -> None:
        self.visisted = []
        self.grid = []
        self.size = 0
        self.shortestPath = MAX_PATH_LENGTH
        self.queue = Queue()

    def shouldJumpIn(self, x: int, y: int, step: int) -> bool:
        coordinatesValid = x >= 0 and y >= 0 and x < self.size and y < self.size
        containsZero = self.grid[x][y] == 0 if coordinatesValid else False
        visisted = self.visisted[x][y] if coordinatesValid else False
        return coordinatesValid and containsZero and not visisted and step < self.shortestPath

    def isTargetReached(self, x, y: int) -> bool:
        return x == (self.size - 1) and y == (self.size - 1)

    def putNextLevel(self, x, y, step: int):
        for xAmount, yAmount in turns:
            nextX = x + xAmount
            nextY = y + yAmount
            nextStep = step + 1
            if self.shouldJumpIn(nextX, nextY, nextStep):
                self.visisted[nextX][nextY] = True
                self.queue.put((nextX, nextY, nextStep))
    
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] == 1:
            return -1
        self.grid = grid
        self.size = size = len(grid)
        self.visisted = [[False]*size for _ in range(size)]
        self.queue.put((0, 0, 1))
        self.visisted[0][0] = True
        while not self.queue.empty():
            levelLength = self.queue.qsize()
            for _ in range(levelLength):
                x, y, step = self.queue.get()
                if self.isTargetReached(x, y):
                    self.shortestPath = min(self.shortestPath, step)
                else:
                    self.putNextLevel(x, y, step)
        if self.shortestPath == MAX_PATH_LENGTH:
            return -1
        return self.shortestPath

s = Solution()
print(s.shortestPathBinaryMatrix([[0,0,0],[1,1,0],[1,1,1]]))
s = Solution()
print(s.shortestPathBinaryMatrix([[0,1],[1,0]]) == 2)
s = Solution()
print(s.shortestPathBinaryMatrix([[0,0,0],[1,1,0],[1,1,0]]) == 4)
s = Solution()
print(s.shortestPathBinaryMatrix([[1,0,0],[1,1,0],[1,1,0]]) == -1)
s = Solution()
print(s.shortestPathBinaryMatrix([[0,0,0],[1,0,0],[1,1,0]]) == 3)
s = Solution()
