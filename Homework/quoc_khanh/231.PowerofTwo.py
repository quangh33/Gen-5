from curses.ascii import SO


class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 0:
            return False
        nMinusOne = n - 1
        return n & nMinusOne == 0

s = Solution()
print(s.isPowerOfTwo(0) == False)
print(s.isPowerOfTwo(1) == True)
print(s.isPowerOfTwo(2) == True)
print(s.isPowerOfTwo(4) == True)
print(s.isPowerOfTwo(8) == True)
print(s.isPowerOfTwo(3) == False)
print(s.isPowerOfTwo(5) == False)
print(s.isPowerOfTwo(6) == False)
print(s.isPowerOfTwo(7) == False)