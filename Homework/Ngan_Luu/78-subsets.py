#https://leetcode.com/problems/subsets/
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n=len(nums)
        subset_list=[]
        for i in range(pow(2,len(nums))):
            subset=[]
            binary="{0:b}".format(i).zfill(len(nums))
            for i in range(len(binary)):
                if binary[i]=='1':
                    subset.append(nums[i])
            subset_list.append(subset)
        return subset_list