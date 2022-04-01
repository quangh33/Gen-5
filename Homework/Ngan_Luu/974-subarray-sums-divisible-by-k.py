#https://leetcode.com/problems/subarray-sums-divisible-by-k/
class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        prefixSum=[]
        remain_map={}
        ans=0
        for i in range(0,len(nums)):
            if i==0:
                prefixSum.append(nums[0])
            else:
                prefixSum.append(prefixSum[-1]+nums[i])
            remain=prefixSum[-1]%k
            if remain ==0:
                ans+=1
            if remain in remain_map:
                remain_map[remain]+=1
                ans+=remain_map[remain]
            else:
                remain_map[remain]=0
        return ans