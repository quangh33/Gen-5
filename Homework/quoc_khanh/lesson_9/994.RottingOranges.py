from queue import Queue
from typing import List

EMPTY = 0
FRESH = 1
ROTTEN = 2

turns = [
    (-1, 0), # UP
    ( 0, 1), # RIGHT
    ( 1, 0), # DOWN
    ( 0,-1), # LEFT
]

class Solution:
    def __init__(self) -> None:
        self.rottenCount = 0
        self.totalOrange = 0
        self.grid = []
        self.rows = 0
        self.cols = 0

    def areAllRotten(self) -> bool:
        return self.rottenCount == self.totalOrange
    
    def shouldJumpIn(self, x: int, y: int) -> bool:
        validCoordinator = x >= 0 and y >= 0 and x < self.rows and y < self.cols
        return validCoordinator and self.grid[x][y] == FRESH

    def orangesRotting(self, grid: List[List[int]]) -> int:
        self.grid = grid
        self.rows, self.cols = len(grid), len(grid[0])
        queue = Queue()
        for i, row in enumerate(grid):
            for j, orange in enumerate(row):
                if orange == FRESH:
                    self.totalOrange += 1
                if orange == ROTTEN:
                    self.rottenCount += 1
                    self.totalOrange += 1
                    queue.put((i, j))
        time = -1
        while not queue.empty():
            levelLength = queue.qsize()
            for _ in range(levelLength):
                rottenX, rottenY = queue.get()
                for amountX, amountY in turns:
                    newX = rottenX + amountX
                    newY = rottenY + amountY
                    if self.shouldJumpIn(newX, newY):
                        grid[newX][newY] = ROTTEN
                        self.rottenCount += 1
                        queue.put((newX, newY))
            time += 1
        if self.areAllRotten():
            return 0 if time == -1 else time
        return -1

s = Solution()
print(s.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))
s = Solution()
print(s.orangesRotting([[2,1,1],[0,1,1],[1,0,1]]))
s = Solution()
print(s.orangesRotting([[0,2]]))