import math
from typing import List


def compare(point1: List[int], point2: List[int]) -> int:
    '''
        return positive int if length from point1 to origin bigger than length from point2 to origin and vice versa
        return 0 if the lengths are equal
    '''
    assert len(point1) == 2
    assert len(point2) == 2
    length1 = math.sqrt(point1[0]**2 + point1[1]**2)
    length2 = math.sqrt(point2[0]**2 + point2[1]**2)
    return length1 - length2

def swap(nums: List[int], index1: int, index2: int):
    nums[index1], nums[index2] = nums[index2], nums[index1]

def divideListInHalf(nums: List[List[int]], startIdx=0, endIdx=None) -> int:
    if endIdx == None:
        endIdx = len(nums) - 1
    if startIdx == endIdx:
        return startIdx
    leftIdx, rightIdx = startIdx, endIdx - 1
    pivotVal = nums[endIdx]
    while rightIdx >= leftIdx:
        if compare(nums[rightIdx], pivotVal) < 0:
            swap(nums, leftIdx, rightIdx)
            leftIdx += 1
        else:
            rightIdx -= 1
    # print(nums, leftIdx, rightIdx)
    swap(nums, endIdx, leftIdx)
    return leftIdx

def find(self, nums: List[List[int]], k: int, startIdx: int, endIdx: int):
        pivotIdx = divideListInHalf(nums, startIdx, endIdx)
        if pivotIdx == k - 1:
            return nums[pivotIdx]
        if pivotIdx > k - 1:
            return self.find(nums, k, startIdx, pivotIdx - 1)
        if pivotIdx < k - 1:
            return self.find(nums, k, pivotIdx + 1, endIdx)

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        pass