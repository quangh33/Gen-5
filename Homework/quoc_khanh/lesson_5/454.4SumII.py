from typing import List


class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        sum12ToFrequency = {}
        for num1 in nums1:
            for num2 in nums2:
                sum12 = num1 + num2
                if sum12 in sum12ToFrequency:
                    sum12ToFrequency[sum12] += 1
                else:
                    sum12ToFrequency[sum12] = 1

        count = 0
        for num3 in nums3:
            for num4 in nums4:
                diff = 0 - num3 - num4
                if diff in sum12ToFrequency:
                    count += sum12ToFrequency[diff]
        return count