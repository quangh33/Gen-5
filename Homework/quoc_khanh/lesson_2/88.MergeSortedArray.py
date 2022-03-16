from typing import List

MIN_VALUE = - 10 ** 9

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        '''
                      r
            1 3 5 0 0 0
                m
            2 4 6
                n
        '''
        pointer1, pointer2, resultPtr = m - 1, n - 1, m + n - 1
        while resultPtr >= 0:
            value1 = nums1[pointer1] if pointer1 >= 0 else MIN_VALUE - 1
            value2 = nums2[pointer2] if pointer2 >= 0 else MIN_VALUE - 1
            if value1 > value2:
                nums1[resultPtr] = value1
                pointer1 -= 1
            else:
                nums1[resultPtr] = value2
                pointer2 -= 1
            resultPtr -= 1
        print(nums1)

s = Solution()
nums1 = [1,3,5,0,0,0]
s.merge(nums1, 3, [2,4,6], 3)
print(nums1 == [1,2,3,4,5,6])

nums1 = [1,2,3,0,0,0]
s.merge(nums1, 3, [2,5,6], 3)
print(nums1 == [1,2,2,3,5,6])

nums1 = [1]
s.merge(nums1, 1, [], 0)
print(nums1 == [1])
        
nums1 = [0]
s.merge(nums1, 0, [1], 1)
print(nums1 == [1])