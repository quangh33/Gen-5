from typing import List

RED, GREEN, BLUE = 0, 1, 2

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        '''
            [[17,2,17],[16,16,5],[14,3,19]]

                r   g   b
            1   17  2   17
            2   18  33  7
            3   21  10  37
            time complexity O(N)
            space complexity O(1)
        '''
        length = len(costs)
        prevCumulativeCost, currCumulativeCost = costs[0], [0,0,0]
        for i in range(1, length):
            for c in [RED, GREEN, BLUE]:
                if c == RED:
                    currCumulativeCost[RED] = \
                    costs[i][RED] + min(prevCumulativeCost[GREEN], prevCumulativeCost[BLUE])
                if c == GREEN:
                    currCumulativeCost[GREEN] = \
                        costs[i][GREEN] + min(prevCumulativeCost[RED], prevCumulativeCost[BLUE])
                if c == BLUE:
                    currCumulativeCost[BLUE] = \
                        costs[i][BLUE] + min(prevCumulativeCost[RED], prevCumulativeCost[GREEN])
            prevCumulativeCost, currCumulativeCost = [*currCumulativeCost], [0,0,0]
        return min(prevCumulativeCost)

s = Solution()
print(s.minCost([[17,2,17],[16,16,5],[14,3,19]]) == 10)