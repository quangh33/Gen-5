from typing import List


class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.prefixSums = []
        prevNum = 0
        for num in nums:
            prevNum += num
            self.prefixSums.append(prevNum)
        

    def sumRange(self, left: int, right: int) -> int:
        return self.prefixSums[right] - self.prefixSums[left] + self.nums[left]
        


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)