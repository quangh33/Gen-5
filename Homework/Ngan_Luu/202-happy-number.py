#https://leetcode.com/problems/happy-number/
class Solution:
    def isHappy(self, n: int) -> bool:
        number_dictionary = {}
        while(n != 1):
            digits = [int(i) for i in str(n)]
            n = 0
            for d in digits:
                n += d*d
            if n not in number_dictionary:
                number_dictionary[n] = 1
            else:
                return False
        return True