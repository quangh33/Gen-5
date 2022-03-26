from collections import Counter
from typing import List

class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        # O(n) space and time
        counts = Counter(nums)
        # O(n Log n) time
        nums = sorted(nums, reverse=True) # sort the numbers in descending order
        # O(n Log n) time
        nums = sorted(nums, key=lambda num: counts[num]) # sort the numbers by frequence in ascending order
        return nums
        

s = Solution()
print(s.frequencySort([1,1,2,2,2,3]) == [3,1,1,2,2,2])
print(s.frequencySort([2,3,1,3,2]) == [1,3,3,2,2])
print(s.frequencySort([-1,1,-6,4,5,-6,1,4,1]) == [5,-1,4,4,-6,-6,1,1,1])