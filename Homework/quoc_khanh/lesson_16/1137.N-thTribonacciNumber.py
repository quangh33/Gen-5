class Solution:
    def tribonacci(self, n: int) -> int:
        t0, t1, t2 = 0, 1, 1
        if n == 0:
            return 0
        if n == 1 or n == 2:
            return 1
        for i in range(3, n+1):
            tmp = t0 + t1 + t2
            t0 = t1
            t1 = t2
            t2 = tmp
        return t2

s = Solution()
print(s.tribonacci(3))
print(s.tribonacci(4))
'''
0 1 1
1 1 2
1 2 4
'''