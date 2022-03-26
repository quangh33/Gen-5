from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        answer = [1] * (length + 1)
        # calculate suffix products
        prev = 1
        for i in reversed(range(length)):
            answer[i] = prev * nums[i]
            prev = answer[i]
        # calculate result
        cumulativeProduct = 1
        for i in range(length):
            answer[i] = cumulativeProduct * answer[i + 1]
            cumulativeProduct *= nums[i]
        return answer[:-1]

s = Solution()
print(s.productExceptSelf([1,2,3,4]) == [24,12,8,6])
print(s.productExceptSelf([-1,1,0,-3,3]) == [0,0,9,0,0])