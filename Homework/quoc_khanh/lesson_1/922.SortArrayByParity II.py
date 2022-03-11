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
        evenPointer = 0
        oddPointer = 1
        pointer = 0
        length = len(nums)
        while pointer < length:
            currentVal = nums[pointer]
            if self.isEven(currentVal) and self.isOdd(pointer):
                self.swap(nums, evenPointer, pointer)
                evenPointer += 2
            elif self.isOdd(currentVal) and self.isEven(pointer):
                self.swap(nums, oddPointer, pointer)
                oddPointer += 2
            else:
                pointer += 1
        return nums

s = Solution()
print(s.sortArrayByParityII([4,2,5,7]))