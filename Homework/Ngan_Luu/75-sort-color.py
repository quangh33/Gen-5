#https://leetcode.com/problems/sort-colors/
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        for a in [0,1,2]:
            p=0
            for i in range(1,len(nums)):
                if nums[p]!=a:
                    p+=1
                elif nums[i]!=a:
                    nums[i],nums[p]=nums[p],nums[i]
                    p+=1