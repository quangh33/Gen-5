from typing import List


def getDigits(n: int) -> List[int]:
    digits = []
    while n > 0:
        digit = n % 10
        digits.insert(0, digit)
        n = n // 10
    return digits

def makeNumber(digits: List[int]) -> int:
    n = 0
    for digit in digits:
        n = n * 10 + digit
    return n

class Solution:
    def nextGreaterElement(self, n: int) -> int:
        digits = getDigits(n)
        length = len(digits)
        '''
            1 2 3 4 5
                    |
            pivot = 3 val = 4
            replaceIdx = 4, val = 5
            12354
            12453 -> 12435
            12543
            13542
            14532
            15432
            25431
        '''
        pivot = None
        replaceIdx = None
        # find the pivot
        for index in reversed(range(length)):
            if index == 0:
                return -1
            if index > 0 and digits[index - 1] < digits[index]:
                pivot = index - 1
                break
        # find the smallest digit at right side of the pivot,
        # and bigger than the pivot
        for index in reversed(range(pivot + 1, length)):
            if digits[index] > digits[pivot]:
                replaceIdx = index
                break
        # swap
        tmp = digits[pivot]
        digits[pivot] = digits[replaceIdx]
        digits[replaceIdx] = tmp
        # sort asc left side of pivot
        c = 0
        tmp = None
        start, end = pivot + 1, length - 1
        while start < end:
            tmp = digits[start]
            digits[start] = digits[end]
            digits[end] = tmp
            start, end = start + 1, end - 1
        # return
        result = makeNumber(digits)
        if result > 2 ** 31 - 1:
            return -1
        return result
s = Solution()
print(s.nextGreaterElement(230241))