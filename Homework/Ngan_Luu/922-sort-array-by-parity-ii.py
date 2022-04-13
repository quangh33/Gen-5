#https://leetcode.com/problems/sort-array-by-parity-ii/ (O(1) extra space)
class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        p=0
        i=1
        while p<len(nums) and i<len(nums):
            if nums[p]%2==0:
                p+=2
            elif nums[i]%2==0:
                nums[p],nums[i]=nums[i],nums[p]
                p+=2
                i+=2
            else:
                i+=2
        return nums