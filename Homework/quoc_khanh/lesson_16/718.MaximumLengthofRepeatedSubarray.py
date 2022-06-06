from typing import List

class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        maxLength = 0
        length1, length2 = len(nums1), len(nums2)
        # dummy value makes length1 become length1 + 1
        nums1.insert(0, None) 
        nums2.insert(0, None)
        arr = [[0]*(length2+1) for _ in range(length1+1)]
        for i in range(1, length1+1):
            for j in range(1, length2+1):
                if nums1[i] == nums2[j]:
                    arr[i][j] = arr[i-1][j-1] + 1
                    maxLength = max(arr[i][j], maxLength)
                else:
                    arr[i][j] = 0
        return maxLength

s = Solution()
print(s.findLength([1,2,3,2,1], [3,2,1,4,7]) == 3)
print(s.findLength([0,0,0,0,0], [0,0,0,0,0]) == 5)
print(s.findLength([0], [1]) == 0)
print(s.findLength([0], [0]) == 1)
print(s.findLength([0, 1], [1, 0]) == 1)
print(s.findLength([1,2,3,4,5,6,7,8,9], [9,0,2,3,4,1,7,8]) == 3)