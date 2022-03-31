#https://leetcode.com/problems/4sum-ii/
class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        count=collections.Counter()
        for x in nums1:
            for y in nums2:
                count[x+y]+=1
        output=0
        for x in nums3:
            for y in nums4:
                output+=count[0-x-y]
        return output