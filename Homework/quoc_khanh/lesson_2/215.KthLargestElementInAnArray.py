from typing import List

def swap(nums: List[int], index1: int, index2: int):
    nums[index1], nums[index2] = nums[index2], nums[index1]

def divideListInHalf(nums: List[int], startIdx=0, endIdx=None) -> int:
    if endIdx == None:
        endIdx = len(nums) - 1
    if startIdx == endIdx:
        return startIdx
    leftIdx, rightIdx = startIdx, endIdx - 1
    pivotVal = nums[endIdx]
    while rightIdx >= leftIdx:
        if nums[rightIdx] > pivotVal:
            swap(nums, leftIdx, rightIdx)
            leftIdx += 1
        else:
            rightIdx -= 1
    # print(nums, leftIdx, rightIdx)
    swap(nums, endIdx, leftIdx)
    return leftIdx

class Solution:
    def find(self, nums: List[int], k: int, startIdx: int, endIdx: int):
        pivotIdx = divideListInHalf(nums, startIdx, endIdx)
        if pivotIdx == k - 1:
            return nums[pivotIdx]
        if pivotIdx > k - 1:
            return self.find(nums, k, startIdx, pivotIdx - 1)
        if pivotIdx < k - 1:
            return self.find(nums, k, pivotIdx + 1, endIdx)

    def findKthLargest(self, nums: List[int], k: int) -> int:
        return self.find(nums, k, 0, len(nums) - 1)

# print(divideListInHalf([1]) == 0)
# print(divideListInHalf([1, 2]) == 0)
# print(divideListInHalf([1, 3, 2]) == 1)

# print(divideListInHalf([1,4,3,5,2]) == 3)
# print(divideListInHalf([1,2,3,4,5,6,2]) == 4)

s = Solution()
print(s.findKthLargest([1], 1) == 1)
print(s.findKthLargest([1,1], 1) == 1)
print(s.findKthLargest([1,2], 1) == 2)
print(s.findKthLargest([1,2], 2) == 1)
print(s.findKthLargest([2,1], 2) == 1)
print(s.findKthLargest([2,1], 1) == 2)
print(s.findKthLargest([3,1,2], 1) == 3)
print(s.findKthLargest([3,1,2], 2) == 2)
print(s.findKthLargest([3,1,2], 3) == 1)
print(s.findKthLargest([3,2,3,1,2,4,5,5,6], 4) == 4)
