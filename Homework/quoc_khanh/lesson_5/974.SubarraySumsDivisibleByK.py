import math
from typing import List

def combination(n: int, r: int) -> int:
    '''
        n: total number of objects in the set
        r: number of choosing objects from the set
    '''
    numerator = math.factorial(n)
    denominator = math.factorial(r) * math.factorial(n - r)
    return numerator // denominator

class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        numOfSubarray = 0
        modToFrequence = {0: 1} # prefix sum % k ---> frequence
        prefixSum = 0
        for num in nums:
            prefixSum += num
            mod = prefixSum % k
            if mod in modToFrequence:
                modToFrequence[mod] += 1
            else:
                modToFrequence[mod] = 1
        
        for mod, frequence in modToFrequence.items():
            if frequence > 1:
                numOfSubarray += combination(frequence, 2)
        return numOfSubarray

s = Solution()
print(s.subarraysDivByK([4,5,0,-2,-3,1], 5) == 7)