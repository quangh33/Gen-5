from itertools import count
from typing import List


class Solution:
    def twoSumSmaller(self, nums: List[int], target: int) -> int:
        result = 0
        left, right = 0, len(nums) - 1

        while left < right:
            leftNum, rightNum = nums[left], nums[right]
            currSum = leftNum + rightNum
            if currSum < target:
                result += (right - left)
                left += 1
            if currSum >= target:
                right -= 1

        return result

    def kSumSmaller(self, nums: List[int], target: int, k: int) -> int:
        if k == 2:
            return self.twoSumSmaller(nums, target)
        length = len(nums)
        i = 0
        count = 0
        while i <= length - k:
            result = self.kSumSmaller(nums[i+1:], target - nums[i], k - 1)
            count += result
            i += 1
        return count
            
    def threeSumSmaller(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return 0
        nums.sort()
        return self.kSumSmaller(nums, target, 3)

s = Solution()
print(s.twoSumSmaller([-2,0,1,3], 2) == 4)
print(s.twoSumSmaller([0,1,3], 4) == 2)
print(s.threeSumSmaller([-2,0,1,3], 2) == 2)
print(s.threeSumSmaller([0], 0) == 0)
print(s.threeSumSmaller([0], -1) == 0)