class Solution:
    def __init__(self) -> None:
        self.pow = {
            0: 1
        }
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n == 1:
            return x
        if n == -1:
            return 1/x
        nLeft = n // 2
        nRight = n - nLeft
        leftPow, rightPow = self.pow.get(nLeft, None), self.pow.get(nRight, None)
        if leftPow == None:
            leftPow = self.myPow(x, nLeft)
            self.pow[nLeft] = leftPow
        if rightPow == None:
            rightPow = self.myPow(x, nRight)
            self.pow[nRight] = rightPow
        return leftPow * rightPow

s = Solution()
print(s.myPow(2,0) == 1)
s = Solution()
print(s.myPow(2,1) == 2)
s = Solution()
print(s.myPow(2,-1) == 0.5)
s = Solution()
print(s.myPow(2,3) == 8)
print(s.pow)
s = Solution()
print(s.myPow(2,-3) == 1/8)
s = Solution()
print(s.myPow(2.1,3))
s = Solution()