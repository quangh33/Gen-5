class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n > 0:
            n &= n - 1
            count += 1
        return count

s = Solution()
print(s.hammingWeight(0) == 0)
print(s.hammingWeight(1) == 1)
print(s.hammingWeight(2) == 1)
print(s.hammingWeight(3) == 2)
print(s.hammingWeight(4) == 1)
print(s.hammingWeight(5) == 2)
print(s.hammingWeight(6) == 2)
print(s.hammingWeight(7) == 3)
print(s.hammingWeight(8) == 1)
print(s.hammingWeight(9) == 2)
print(s.hammingWeight(16) == 1)
print(s.hammingWeight(100) == 3)
print(s.hammingWeight(1234) == 5)