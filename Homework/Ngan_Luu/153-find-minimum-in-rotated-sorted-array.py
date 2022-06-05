# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
class Solution:
    def findMin(self, nums: List[int]) -> int:
        #condition of min value a at index of i: nums[i-1]>i and nums[i+1]>i
        if nums[0]<=nums[-1]:
            return nums[0]
        start=0
        end=len(nums)-1
        while start<=end:
            mid=(start+end)//2
            if nums[mid+1]<nums[mid]:
                return nums[mid+1]
            if nums[mid]>=nums[start]:
                start=mid+1
            else:
                end=mid-1
