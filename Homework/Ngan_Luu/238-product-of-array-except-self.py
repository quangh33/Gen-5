https://leetcode.com/problems/product-of-array-except-self/
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n=len(nums)
        output=[]
        prefixProduct=[nums[0]]*n
        suffixProduct=[nums[-1]]*n
        for i in range(1,n):
            prefixProduct[i]=prefixProduct[i-1]*nums[i]
            suffixProduct[n-1-i]=suffixProduct[n-i]*nums[n-1-i]
        output.append(suffixProduct[1])  #i=0
        for i in range(1,n-1):
            output.append(prefixProduct[i-1]*suffixProduct[i+1])
        output.append(prefixProduct[n-2]) #i=n-1
        return output
