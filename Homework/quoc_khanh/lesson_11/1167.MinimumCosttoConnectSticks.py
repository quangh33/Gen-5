import heapq
from typing import List


class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        heapq.heapify(sticks)
        cost = 0
        while len(sticks) > 1:
            v1 = heapq.heappop(sticks)
            v2 = heapq.heappop(sticks)
            cost += v1 + v2
            heapq.heappush(sticks, v1 + v2)
        return cost

s = Solution()
print(s.connectSticks([2,3,4]) == 14)
print(s.connectSticks([1,8,3,5]) == 30)
print(s.connectSticks([5]) == 0)