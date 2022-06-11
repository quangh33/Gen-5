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
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        WELL_INDEX = n
        d = DisjoinSet(n + 1) # plus a well
        queue = PriorityQueue()
        for pipe in pipes:
            indexX, indexY, cost = pipe
            queue.put((cost, indexX - 1, indexY - 1))
        for house, cost in enumerate(wells):
            queue.put((cost, WELL_INDEX, house))
        edgeUsed = 0
        totalCost = 0
        while not queue.empty():
            cost, indexX, indexY = queue.get()
            if d.union(indexX, indexY) == True:
                totalCost += cost
                edgeUsed += 1
            if edgeUsed == n:
                break
        return totalCost

s = Solution()
n, wells, pipes = 5, [46012,72474,64965,751,33304], [[2,1,6719],[3,2,75312],[5,3,44918]]
print(s.minCostToSupplyWater(n, wells, pipes) == 131704)
n, wells, pipes = 3, [1,2,2], [[1,2,1],[2,3,1]]
print(s.minCostToSupplyWater(n, wells, pipes) == 3)
n, wells, pipes = 2, [1,1], [[1,2,1],[1,2,2]]
print(s.minCostToSupplyWater(n, wells, pipes) == 2)