from typing import List


def getBits(n: int, size: int) -> List[int]:
    bits = [0] * size
    index = size - 1
    while n > 0:
        bit = n & 1
        if bit:
            bits[index] = 1
        index -= 1
        n = n >> 1
    return bits

def getSubset(nums: List[int], mask: List[int]) -> List[int]:
    subset = []
    for idx, bit in enumerate(mask):
        if bit:
            subset.append(nums[idx])
    return subset

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        results = []
        for i in range(0, 2 ** size):
            mask = getBits(i, size)
            results.append(getSubset(nums, mask))
        print(results)
        return results

s = Solution()
results = [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
print(s.subsets([1,2,3]))

print(getSubset([1,2,3,4], [0,0,0,0]) == [])
print(getSubset([1,2,3,4], [1,0,0,0]) == [1])
print(getSubset([1,2,3,4], [0,1,0,0]) == [2])
print(getSubset([1,2,3,4], [0,0,0,1]) == [4])
print(getSubset([1,2,3,4], [1,0,1,0]) == [1,3])
print(getSubset([1,2,3,4], [0,1,0,1]) == [2,4])
print(getSubset([1,2,3,4], [1,1,0,1]) == [1,2,4])
print(getSubset([1,2,3,4], [1,1,1,1]) == [1,2,3,4])

print(getBits(0, 4) == [0,0,0,0])
print(getBits(2, 4) == [0,0,1,0])
print(getBits(3, 4) == [0,0,1,1])
print(getBits(4, 4) == [0,1,0,0])
print(getBits(5, 4) == [0,1,0,1])
print(getBits(6, 4) == [0,1,1,0])
print(getBits(7, 4) == [0,1,1,1])
print(getBits(15, 4) == [1,1,1,1])