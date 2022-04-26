from typing import List

MAX_VAL = 5000 + 1

class Solution:
    def binarySearch(self, nums: List[int], begin: int, end: int) -> int:
        pivotIdx = (end + begin) // 2
        pivotVal = nums[pivotIdx]
        if begin > end:
            return MAX_VAL
        return min(pivotVal, self.binarySearch(nums, begin, pivotIdx - 1))

    def binarySearchRotatedArray(self, nums: List[int], begin: int, end: int) -> int:
        pivotIdx = (end + begin) // 2
        pivotVal = nums[pivotIdx]
        if begin > end:
            return MAX_VAL
        if pivotVal <= nums[begin] and pivotVal <= nums[end]:
            return min(pivotVal, self.binarySearchRotatedArray(nums, begin, pivotIdx - 1))
        if pivotVal >= nums[begin] and pivotVal >= nums[end]:
            return min(pivotVal, self.binarySearchRotatedArray(nums, pivotIdx + 1, end))
        if pivotVal >= nums[begin] and pivotVal <= nums[end]:
            return min(pivotVal, self.binarySearch(nums, begin, pivotIdx - 1))
    def findMin(self, nums: List[int]) -> int:
        length = len(nums)
        return self.binarySearchRotatedArray(nums, 0, length - 1)

s = Solution()
print(s.findMin([3,4,5,1,2]) == 1)
print(s.findMin([4,5,6,7,0,1,2]) == 0)
print(s.findMin([11,13,15,17]) == 11)