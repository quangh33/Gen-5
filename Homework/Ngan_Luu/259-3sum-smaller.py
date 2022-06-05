# https://leetcode.com/problems/3sum-smaller/
class Solution:
    def threeSumSmaller(self, nums: List[int], target: int) -> int:
        nums.sort()
        res=0
        for i in range(0,len(nums)-2):
            start=i+1
            end=len(nums)-1
            while start<end:
                if nums[i]+nums[start]+nums[end]>=target:
                    end-=1
                else:
                    res+=end-start
                    start+=1
        return res