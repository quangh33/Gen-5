from typing import List
from xml.dom.pulldom import parseString


class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        numToFreq = {}
        numToIndices = {}
        degree = 0

        for index, num in enumerate(nums):
            # calculate the freq
            if num in numToFreq:
                numToFreq[num] += 1
            else:
                numToFreq[num] = 1
            # degree
            degree = max(degree, numToFreq[num])
            # store index
            if num in numToIndices:
                start, _ = numToIndices[num]
                numToIndices[num] = (start, index)
            else:
                numToIndices[num] = (index, index)
        
        minLength = 50001
        for num, freq in numToFreq.items():
            if freq == degree:
                start, end = numToIndices[num]
                subarrayLen = end - start + 1
                minLength = min(minLength, subarrayLen)
        
        return minLength

s = Solution()
print(s.findShortestSubArray([1,2,2,3,1]) == 2)
print(s.findShortestSubArray([1,2,2,3,1,4,2]) == 6)
print(s.findShortestSubArray([1,2,2,3,1,4,2]) == 6)