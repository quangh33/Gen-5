from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        prev = 0
        for num in nums:
            prev = prev ^ num
        return prev

s = Solution()
print(s.singleNumber([2,2,1]) == 1)
print(s.singleNumber([4,1,2,1,2]) == 4)
print(s.singleNumber([1]) == 1)
