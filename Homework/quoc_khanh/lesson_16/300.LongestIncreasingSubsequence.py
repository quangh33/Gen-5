from typing import List

MIN = -1*10**4

def indexOf(nums, num):
    '''
        return index of the smallest number >= input num
    '''
    left, right = 0, len(nums) - 1
    previousPivot = None
    while left <= right:
        pivot = (right + left) // 2
        pivotVal = nums[pivot]
        if pivotVal == num:
            return pivot
        if pivotVal < num:
            left = pivot + 1
        if pivotVal > num:
            previousPivot = pivot
            right = pivot - 1
    return previousPivot

class Solution:
    def lengthOfLIS1(self, nums: List[int]) -> int:
        '''
            Time Limit Exceeded :')
        '''
        length = len(nums)
        lenUntil = [1] * length
        lenUntil[0] = 1
        maxLenght = 1
        for i in range(1, length):
            for j in range(0, i):
                if nums[j] < nums[i]:
                    lenUntil[i] = max(lenUntil[i], lenUntil[j] + 1)
                maxLenght = max(maxLenght, lenUntil[i])
        return maxLenght

    def lengthOfLIS(self, nums: List[int]) -> int:
        '''
        https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308
        '''
        arr = []
        def lastNum():
            nonlocal arr
            return arr[-1] if len(arr) > 0 else MIN - 1

        for num in nums:
            if num > lastNum():
                arr.append(num)
            else:
                index = indexOf(arr, num)
                arr[index] = num
        return len(arr)

# print(indexOf([1], 1) == 0)
# print(indexOf([1], 0) == 0)
# print(indexOf([1], 2) == None)

# print(indexOf([1,3], 0) == 0)
# print(indexOf([1,3], 1) == 0)
# print(indexOf([1,3], 2) == 1)
# print(indexOf([1,3], 3) == 1)
# print(indexOf([1,3], 4) == None)

# print(indexOf([1,3,6,8], 1) == 0)
# print(indexOf([1,3,6,8], 0) == 0)
# print(indexOf([1,3,6,8], 3) == 1)
# print(indexOf([1,3,6,8], 2) == 1)
# print(indexOf([1,3,6,8], 6) == 2)
# print(indexOf([1,3,6,8], 4) == 2)
# print(indexOf([1,3,6,8], 5) == 2)
# print(indexOf([1,3,6,8], 8) == 3)
# print(indexOf([1,3,6,8], 7) == 3)
# print(indexOf([1,3,6,8], 9) == None)

s = Solution()
print(s.lengthOfLIS([10,9,2,5,3,7,101,18])) # 4
print(s.lengthOfLIS([0,1,0,3,2,3])) # 4
print(s.lengthOfLIS([7,7,7,7,7,7,7])) # 1