#https://leetcode.com/problems/sort-array-by-parity 
class Solution:            
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        p=0
        for i in range(1,len(nums)):
            if nums[p]%2==0:
                p+=1
            elif nums[i]%2==0:
                nums[p],nums[i]=nums[i],nums[p]
                p+=1
        return nums