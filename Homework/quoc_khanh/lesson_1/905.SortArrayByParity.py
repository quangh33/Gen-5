from typing import List

class Solution:
    def swap(self, nums: List[int], index1: int, index2: int):
        nums[index1], nums[index2] = nums[index2], nums[index1]

    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        pivot = 0
        pointer = 0
        length = len(nums)
        while pointer < length:
            if nums[pointer] % 2 == 0:
                self.swap(nums, pivot, pointer)
                pivot += 1
            pointer += 1
        return nums

s = Solution()
s.sortArrayByParity([3,1,2,4])