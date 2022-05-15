from collections import defaultdict
import math
from typing import List, Set

class DisjoinSet:
    def __init__(self, items: List[int]) -> None:
        self.parents = {}
        self.ranks = {}
        self.counts = {}
        self.maxCount = 1
        for item in items:
            self.parents[item] = item
            self.ranks[item] = 1
            self.counts[item] = 1

    def find(self, item: int) -> int:
        key = item
        while True:
            val = self.parents[key]
            if val == key:
                break
            key = val
        return val

    def union(self, x: int, y: int):
        rootX, rootY = self.find(x), self.find(y)
        if rootX == rootY:
            return
        rankX, rankY = self.ranks[rootX], self.ranks[rootY]
        if rankX < rankY:
            self.parents[rootX] = rootY
            self.counts[rootY] += self.counts[rootX]
            self.counts[rootX] = 0
        elif rankX > rankY:
            self.parents[rootY] = rootX
            self.counts[rootX] += self.counts[rootY]
            self.counts[rootY] = 0
        else:
            self.parents[rootY] = rootX
            self.ranks[rootX] += 1
            self.counts[rootX] += self.counts[rootY]
            self.counts[rootY] = 0
        self.maxCount = max(self.counts[rootX], self.counts[rootY], self.maxCount)

class Solution:
    def primeFactors(self, n: int) -> Set[int]:
        for i in range(2, int(math.sqrt(n))+1):
            if n % i == 0:
                return self.primeFactors(n//i) | set([i])
        return set([n])

    def largestComponentSize(self, nums: List[int]) -> int:
        # calculate prime factors for each number
        num2primeFactors = defaultdict(list)
        for num in nums:
            factors = self.primeFactors(num)
            for item in factors:
                num2primeFactors[item].append(num) # map factor number to num
        # find minimum spaning tree
        d = DisjoinSet(nums)
        for val in list(num2primeFactors.values()):
            for index in range(len(val)-1):
                d.union(val[index], val[index + 1])
        return d.maxCount

s = Solution()
print(s.largestComponentSize([4,6,15,35]) == 4)
print(s.largestComponentSize([20,50,9,63]) == 2)
print(s.largestComponentSize([2,3,6,7,4,12,21,39]) == 8)