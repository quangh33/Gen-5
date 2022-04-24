from queue import PriorityQueue, Queue
from typing import List

turns = [
    (-1, 0), # UP
    ( 0, 1), # RIGHT
    ( 1, 0), # DOWN
    ( 0,-1), # LEFT
]

class Solution:
    def __init__(self) -> None:
        self.grid = []
        self.visisted = []
        self.rows = 0
        self.cols = 0

    def shouldJumpIn(self, x: int, y: int, score: int) -> bool:
        validCoordinator = x >= 0 and y >= 0 and x < self.rows and y < self.cols
        return validCoordinator and self.visisted[x][y] == False and self.grid[x][y] >= score
    
    def clearVisisted(self):
        self.visisted = [[False] * self.cols for _ in range(self.rows)]

    def reachTarget(self, x: int, y: int) -> bool:
        return x == self.rows - 1 and y == self.cols - 1

    def markVisisted(self, x: int, y: int):
        self.visisted[x][y] = True

    def isPathScoreExist(self, score: int) -> bool:
        if self.grid[0][0] < score:
            return False
        queue = Queue()
        queue.put((0, 0))
        while not queue.empty():
            row, col = queue.get()
            if self.reachTarget(row, col):
                return True
            for x, y in turns:
                nextRow = row + x
                nextCol = col + y
                if self.shouldJumpIn(nextRow, nextCol, score):
                    self.markVisisted(nextRow, nextCol)
                    queue.put((nextRow, nextCol))
        return False

    def maximumMinimumPath1(self, grid: List[List[int]]) -> int:
        '''
            binary search + BFS => Time Limit Exceeded on Python
        '''
        self.grid, self.rows, self.cols = grid, len(grid), len(grid[0])
        minVal, maxVal = 0, grid[0][0]
        for row in grid:
            for cell in row:
                minVal = min(minVal, cell)
        left, right = minVal, maxVal
        
        maxScore = -1
        while left <= right:
            pivot = (left + right) // 2
            self.clearVisisted()
            if self.isPathScoreExist(pivot):
                left = pivot + 1
                maxScore = max(pivot, maxScore)
            else:
                right = pivot - 1
        return maxScore

    def maximumMinimumPath(self, grid: List[List[int]]) -> int:
        '''
            BFS + Priority queue
        '''
        self.grid = grid
        self.rows = len(grid)
        self.cols = len(grid[0])
        self.visisted = [[False] * self.cols for _ in range(self.rows)]
        queue = PriorityQueue()
        self.markVisisted(0, 0)
        minScore = grid[0][0]
        queue.put((-minScore, 0, 0))
        while not queue.empty():
            score, row, col = queue.get()
            minScore = min(minScore, grid[row][col])
            if self.reachTarget(row, col):
                return minScore
            for rowDelta, colDelta in turns:
                nextRow = row + rowDelta
                nextCol = col + colDelta
                if self.shouldJumpIn(nextRow, nextCol, 0):
                    self.markVisisted(nextRow, nextCol)
                    score = grid[nextRow][nextCol]
                    queue.put((-score, nextRow, nextCol))
        return minScore


s = Solution()
print(s.maximumMinimumPath([[5,4,5],[1,2,6],[7,4,6]]) == 4)
print(s.maximumMinimumPath([[2,2,1,2,2,2],[1,2,2,2,1,2]]) == 2)
arr = [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
print(s.maximumMinimumPath(arr) == 3)