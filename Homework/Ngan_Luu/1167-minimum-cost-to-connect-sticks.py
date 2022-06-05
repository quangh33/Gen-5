# https://leetcode.com/problems/minimum-cost-to-connect-sticks/
from heapq import heapify,heappop
class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        heapify(sticks)
        total=0
        while len(sticks)>1:
            s1=heappop(sticks)
            s2=heappop(sticks)
            total=total+s1+s2
            heappush(sticks,s1+s2)
        return total