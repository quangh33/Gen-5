from queue import Queue
from typing import List


UNPROCCESSED = -1

turns = [
    (-1,  0), # UP
    ( 0,  1), # RIGHT
    ( 1,  0), # BOTTOM
    ( 0, -1), # LEFT
]


class Solution:
    def __init__(self) -> None:
        self.mat = List[List[int]]
        self.rows = 0
        self.cols = 0

    def shoudProcessCell(self, x, y: int) -> bool:
        validCoordinator = x >= 0 and y >= 0 and x < self.rows and y < self.cols
        unProccessed = self.mat[x][y] == UNPROCCESSED if validCoordinator else False
        return validCoordinator and unProccessed

    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = Queue()
        self.mat = mat
        self.rows = rows = len(mat)
        self.cols = cols = len(mat[0])
        # we put all the zero to queue first
        for row in range(rows):
            for col in range(cols):
                if mat[row][col] == 0:
                    queue.put((row, col))
                else:
                    mat[row][col] = UNPROCCESSED
        # calculate distance
        while not queue.empty():
            row, col = queue.get()
            for rowDelta, colDelta in turns:
                nextRow = row + rowDelta
                nextCol = col + colDelta
                if self.shoudProcessCell(nextRow, nextCol):
                    mat[nextRow][nextCol] = mat[row][col] + 1
                    queue.put((nextRow, nextCol))
        return mat

s = Solution()
mat = [[0,0,0],[0,1,0],[0,0,0]]
s.updateMatrix(mat)
print(mat == [[0,0,0],[0,1,0],[0,0,0]])

mat = [[0,0,0],[0,1,0],[1,1,1]]
s.updateMatrix(mat)
print(mat == [[0,0,0],[0,1,0],[1,2,1]])