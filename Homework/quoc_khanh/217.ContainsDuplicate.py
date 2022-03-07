#https://leetcode.com/problems/contains-duplicate

from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        distintNums = set([])
        for num in nums:
            if num in distintNums:
                return True
            else:
                distintNums.add(num)
        return False

s = Solution()
print(s.containsDuplicate([1]) == False)
print(s.containsDuplicate([1, 2]) == False)
print(s.containsDuplicate([1, 1]) == True)
print(s.containsDuplicate([1,2,3,1]) == True)
print(s.containsDuplicate([1,2,3,4]) == False)
print(s.containsDuplicate([1,1,1,3,3,4,3,2,4,2]) == True)
