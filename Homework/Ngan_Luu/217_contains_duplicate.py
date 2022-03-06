#https://leetcode.com/problems/contains-duplicate/
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:        
        d={}
        for n in nums:
            if n in d:
                return True
            else:
                d[n]=0
        return False