from queue import Queue


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        s = s + ' '
        charToCount = {}
        counts = {}
        totalUniqueChar = 0
        queue = Queue()
        matchedUniqeCharCount = 0
        minLength = 10**5+1
        minSubStr = ''
        for char in t:
            charToCount[char] = 0
            if char in counts:
                counts[char] += 1
            else:
                counts[char] = 1
        totalUniqueChar = len(charToCount)
        back, front = 0, 0
        lenS, lenT = len(s), len(t)
        while front < lenS:
            while matchedUniqeCharCount == totalUniqueChar:
                firstMatchedChar, back = queue.get()
                if front - back < minLength:
                    minLength = front - back
                    minSubStr = s[back:front]
                count = charToCount[firstMatchedChar] = charToCount[firstMatchedChar] - 1
                if count < counts[firstMatchedChar]:
                    matchedUniqeCharCount -= 1

            currChar = s[front]
            if currChar in charToCount:
                queue.put((currChar, front))
                charToCount[currChar] += 1
                count = charToCount[currChar]
                if count == counts[currChar]:
                    matchedUniqeCharCount += 1
            
            front += 1

        return minSubStr


s = Solution()
print(s.minWindow("bba", "ba") == "ba")
print(s.minWindow("bbaac", "aba") == "baa")
print(s.minWindow("ADOBECODEBANC", "ABC") == "BANC")
print(s.minWindow("aa", "aa") == "aa")
print(s.minWindow("ab", "b") == "b")
print(s.minWindow("a", "a") == "a")
print(s.minWindow("a", "aa") == "")
