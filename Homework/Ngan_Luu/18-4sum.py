# https://leetcode.com/problems/4sum/
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        res=set()
        N=len(nums)
        nums.sort()
        for i in range(N-3):
            for j in range(i+1,N-2):
                tmp_target=target-nums[i]-nums[j]
                low = j+1
                high= N-1
                while low < high:
                    tmp_sum=nums[low]+nums[high]
                    if tmp_sum==tmp_target:
                        new_res=(nums[i],nums[j],nums[low],nums[high])
                        if new_res not in res:
                            res.add(new_res)
                        low+=1
                        high-=1
                    elif tmp_sum<tmp_target:
                        low+=1
                    else:
                        high-=1
        return res