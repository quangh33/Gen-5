from typing import List


class Solution:
    def swap(self, nums: List[int], index1: int, index2: int):
        nums[index1], nums[index2] = nums[index2], nums[index1]

    def sortColors(self, nums: List[int]) -> None:
        length = len(nums)
        leftSideBoundaryIdx = 0           # left side for zeros, grow to right
        rightSideBoundaryIdx = length - 1 # right side for number twos, grow to the left
        pointerIdx = 0                    # index of current value that we are considering
        while pointerIdx <= rightSideBoundaryIdx:
            currentVal = nums[pointerIdx]
            if currentVal == 0: # move zero to left side
                self.swap(nums, pointerIdx, leftSideBoundaryIdx)
                pointerIdx += 1
                leftSideBoundaryIdx += 1
            elif currentVal == 1: # let number one stand still
                pointerIdx += 1
            elif currentVal == 2: # move number two to the right side
                self.swap(nums, pointerIdx, rightSideBoundaryIdx)
                rightSideBoundaryIdx -= 1

s = Solution()
s.sortColors([2,2,1,1,0,0])
s.sortColors([2,0,2,1,1,0])