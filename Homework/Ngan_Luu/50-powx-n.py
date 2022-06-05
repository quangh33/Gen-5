# https://leetcode.com/problems/powx-n/
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n<0:
            return 1/self.myPow(x,-n)
        if n==0:
            return 1
        if n==1:
            return x
        tmp=self.myPow(x,n//2)
        if n%2==0:
            return tmp*tmp
        if n%2==1:
            return tmp*tmp*x        