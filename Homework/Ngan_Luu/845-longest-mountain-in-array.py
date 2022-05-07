# https://leetcode.com/problems/longest-mountain-in-array/
class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        slow=0
        res=0
        while slow<len(arr):
            fast=slow
            if fast+1<len(arr) and arr[fast]<arr[fast+1]:
                while fast+1<len(arr) and arr[fast]<arr[fast+1] :
                    fast+=1
                if  fast+1<len(arr) and arr[fast]>arr[fast+1]:
                    while fast+1<len(arr) and arr[fast]>arr[fast+1]:
                        fast+=1
                    res=max(res,fast-slow+1)
            slow=max(fast,slow+1)
        return res