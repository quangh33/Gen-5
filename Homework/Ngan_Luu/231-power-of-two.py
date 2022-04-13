#https://leetcode.com/problems/power-of-two/
# Time: O(1)
# Space: O(1)
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        print(n&(n-1))
        return (n>0) and not(n&(n-1))