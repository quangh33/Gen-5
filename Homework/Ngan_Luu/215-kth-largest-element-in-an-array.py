https://leetcode.com/problems/kth-largest-element-in-an-array/
def quickSelect(nums,left,right,k):
    p=left
    for i in range(left,right):
        if nums[i]>=nums[right]:
            nums[i],nums[p]=nums[p],nums[i]
            p+=1
    nums[p],nums[right]=nums[right],nums[p]
    if p>k:
        return quickSelect(nums,left,p-1,k)
    elif p<k:
        return quickSelect(nums,p+1,right,k)
    else:
        return nums[p]
class Solution:  
    def findKthLargest(self, nums: List[int], k: int) -> int:
        k=k-1 #index start with 0
        return quickSelect(nums,0,len(nums)-1,k)