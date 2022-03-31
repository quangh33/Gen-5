#https://leetcode.com/problems/contains-duplicate-ii/
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        index_map={}
        for i in range(len(nums)):
            if nums[i] in index_map:
                if i-index_map[nums[i]]<=k:
                    return True
            index_map[nums[i]]=i