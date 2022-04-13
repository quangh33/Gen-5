#https://leetcode.com/problems/single-number
# Time:  O(n)
# Space: O(1)
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        for i in range(len(nums)-1):
            nums[i+1]=nums[i]^nums[i+1]
        return nums[len(nums)-1]