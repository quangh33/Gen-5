#https://leetcode.com/problems/number-of-1-bits/
#Time: 	O(log2(n)-1)
#Space: O(1)
class Solution:
    def hammingWeight(self, n: int) -> int:
        count=0
        while(n):
            count+=(n&1)
            n>>=1
        return count