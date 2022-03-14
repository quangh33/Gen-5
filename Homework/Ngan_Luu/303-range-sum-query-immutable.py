#https://leetcode.com/problems/range-sum-query-immutable/
#Time:  O(n)
#Space: 0(n)
class NumArray:
    def __init__(self, nums: List[int]):
        self.prefixSum=nums
        for i in range(len(nums)-1):
            self.prefixSum[i+1]=self.prefixSum[i+1]+self.prefixSum[i]
    def sumRange(self, left: int, right: int) -> int:
        if left==0:
            return self.prefixSum[right]
        else:
            return self.prefixSum[right]-self.prefixSum[left-1]