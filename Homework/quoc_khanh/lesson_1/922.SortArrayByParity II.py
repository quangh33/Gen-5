from typing import List


class Solution:
    def swap(self, nums: List[int], index1: int, index2: int):
        nums[index1], nums[index2] = nums[index2], nums[index1]

    def isEven(self, num: int) -> bool:
        return num % 2 == 0
    
    def isOdd(self, num: int) -> bool:
        return num % 2 != 0

    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        '''
                |
            2 1 4 6 8 9 2 3
                  |
        '''
        evenIdx = 0
        oddIdx = 1
        currIdx = 0
        length = len(nums)
        while currIdx < length:
            currVal = nums[currIdx]
            if self.isEven(currVal) and self.isOdd(currIdx):
                self.swap(nums, evenIdx, currIdx)
                evenIdx += 2
            elif self.isOdd(currVal) and self.isEven(currIdx):
                self.swap(nums, oddIdx, currIdx)
                oddIdx += 2
            else:
                currIdx += 1
        return nums

s = Solution()
print(s.sortArrayByParityII([4,2,5,7]))