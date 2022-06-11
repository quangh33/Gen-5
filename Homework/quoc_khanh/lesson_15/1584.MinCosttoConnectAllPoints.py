from queue import PriorityQueue
from typing import List


class DisjoinSet:
    def __init__(self, size) -> None:
        self.parents = {}
        self.ranks = {}
        for item in range(size):
            self.parents[item] = item
            self.ranks[item] = 1

    def find(self, item: int) -> int:
        key = item
        while True:
            val = self.parents[key]
            if val == key:
                break
            key = val
        return val

    def union(self, x: int, y: int) -> bool:
        rootX, rootY = self.find(x), self.find(y)
        if rootX == rootY:
            return False
        rankX, rankY = self.ranks[rootX], self.ranks[rootY]
        if rankX < rankY:
            self.parents[rootX] = rootY
        elif rankX > rankY:
            self.parents[rootY] = rootX
        else:
            self.parents[rootY] = rootX
            self.ranks[rootX] += 1
        return True

class Solution:
    def manhattanDistance(self, pointX: List[int], pointY: List[int]) -> int:
        xx, xy = pointX
        yx, yy = pointY
        return abs(yx - xx) + abs(yy - xy)

    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        length = len(points)
        # sort all possible edges
        queue = PriorityQueue()
        for i in range(length):
            for j in range(i + 1, length):
                distance = self.manhattanDistance(points[i], points[j])
                queue.put((distance, i, j))
        # find MST
        d = DisjoinSet(length)
        cost = 0
        edgeUsed = 0
        while not queue.empty():
            distance, indexX, indexY = queue.get()
            if d.union(indexX, indexY) == True:
                cost += distance
                edgeUsed += 1
                if edgeUsed == length - 1:
                    break
        return cost
    
s = Solution()
print(s.minCostConnectPoints([[0,0],[2,2],[3,10],[5,2],[7,0]]) == 20)
print(s.minCostConnectPoints([[3,12],[-2,5],[-4,1]]) == 18)