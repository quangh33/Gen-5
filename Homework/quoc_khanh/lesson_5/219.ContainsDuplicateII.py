from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        latestIndices = {}
        for numCurrentIndex, num in enumerate(nums):
            numLatestIndex = latestIndices.get(num, -1)
            if numLatestIndex >= 0:
                if numCurrentIndex - numLatestIndex <= k:
                    return True
            latestIndices[num] = numCurrentIndex
        return False

s = Solution()
s.containsNearbyDuplicate([1,2,3,1], 3)