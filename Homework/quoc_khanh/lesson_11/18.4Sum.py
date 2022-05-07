from typing import List

class Solution:
    def twoSum(self, nums:List[int], target: int) -> List[List[int]]:
        result = []
        left, right = 0, len(nums) - 1

        def decreaseRight():
            nonlocal left, right
            while left < right and nums[right] == nums[right - 1]:
                right -= 1
            right -= 1
        
        def increaseLeft():
            nonlocal left, right
            while right > left and nums[left + 1] == nums[left]:
                left += 1
            left += 1

        while left < right:
            leftNum, rightNum = nums[left], nums[right]
            currSum = leftNum + rightNum
            if currSum == target:
                result.append([leftNum, rightNum])
                increaseLeft()
                decreaseRight()
            if currSum > target:
                decreaseRight()
            if currSum < target:
                increaseLeft()
        return result

    def kSum(self, nums: List[int], target: int, k: int) -> List[List[int]]:
        if k == 2:
            return self.twoSum(nums, target)
        length = len(nums)
        result = []
        i = 0
        while i <= length - k:
            currentNum = nums[i]
            results = self.kSum(nums[i+1:], target - currentNum, k - 1)
            for res in results:
                result.append([currentNum, *res])
            while i < length - k and nums[i] == nums[i+1]:
                i += 1
            i += 1
        return result

    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        return self.kSum(nums, target, 4)

s = Solution()
# print(s.fourSum([1,0,-1,0,-2,2], 0) == [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]])
print(s.fourSum([2,2,2,2], 8) == [[2,2,2,2]])

print(s.twoSum([1,2,3,4,5], 6) == [[1, 5],[2,4]])
print(s.twoSum([1,1,2,2,3,3,4,4,5,5], 6) == [[1, 5], [2, 4], [3, 3]])
print(s.twoSum([2,2,2,2,2,2], 4) == [[2,2]])
print(s.twoSum([2,2], 4) == [[2,2]])