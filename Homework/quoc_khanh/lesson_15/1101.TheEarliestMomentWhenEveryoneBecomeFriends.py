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
    def earliestAcq(self, logs: List[List[int]], n: int) -> int:
        d = DisjoinSet(n)
        queue = PriorityQueue()
        for log in logs:
            queue.put(log)
        edgeUsed = 0
        while not queue.empty():
            timestamp, indexX, indexY = queue.get()
            if d.union(indexX, indexY) == True:
                edgeUsed += 1
            if edgeUsed == n - 1:
                return timestamp
        return -1

s = Solution()
logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]]
print(s.earliestAcq(logs, 6) == 20190301)
logs = [[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]]
print(s.earliestAcq(logs, 4) == 3)
