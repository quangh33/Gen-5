from typing import List

class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        result = [0]*length
        for update in updates:
            start, end, value = update
            result[start] += value
            if end + 1 < length:
                result[end+1] -= value
        cumulativeSum = 0
        print(result)
        for i in range(length):
            cumulativeSum += result[i]
            result[i] = cumulativeSum
        print(result)
        return result

s = Solution()
print(s.getModifiedArray(5, [[1,3,2],[2,4,3],[0,2,-2]]) == [-2,0,3,5,3])
print(s.getModifiedArray(10, [[2,4,6],[5,6,8],[1,9,-4]]) == [0,-4,2,2,2,4,4,-4,-4,-4])