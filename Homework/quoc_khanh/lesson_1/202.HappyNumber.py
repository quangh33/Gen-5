from typing import List


def getDigits(n: int) -> List[int]:
    if n == 0:
        return [0]
    digits = []
    while n > 0:
        digit = n % 10
        digits.append(digit)
        n = n // 10
    return digits

def getSumSquareOfDigits(n: int) -> int:
    sum = 0
    digits = getDigits(n)
    for digit in digits:
        sum += digit ** 2
    return sum

class Solution:
    def isHappy(self, n: int) -> bool:
        slow, fast = n, n
        while True:
            slow = getSumSquareOfDigits(slow)
            fast = getSumSquareOfDigits(fast)
            fast = getSumSquareOfDigits(fast)
            if slow == 1 or fast == 1:
                return True
            if slow == fast:
                return False
            