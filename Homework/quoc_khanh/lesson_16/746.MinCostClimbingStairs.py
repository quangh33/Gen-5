from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        length = len(cost)
        if length == 2:
            return min(cost[0], cost[1])
        cost.append(0)
        cumulativeCost = cost[:2] 
        for i in range(2, length + 1):
            currCost = min(cumulativeCost[i - 1], cumulativeCost[i - 2]) + cost[i]# cost to reach i th stair
            cumulativeCost.append(currCost)
        return cumulativeCost[-1]

s = Solution()
print(s.minCostClimbingStairs([10,15,20]) == 15)
print(s.minCostClimbingStairs([1,100,1,1,1,100,1,1,100,1]) == 6)