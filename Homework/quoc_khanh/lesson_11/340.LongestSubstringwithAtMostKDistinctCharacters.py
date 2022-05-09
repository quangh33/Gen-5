class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        if k == 0:
            return 0
        back, front = 0, 0
        charToCount = {}
        uniqueCharCount = 0
        maxLength = 0

        def countChar(char) -> int:
            nonlocal charToCount
            if char in charToCount:
                charToCount[char] += 1
            else:
                charToCount[char] = 1
            return charToCount[char]

        length = len(s)
        while front < length or uniqueCharCount == k:
            while uniqueCharCount <= k and front < length:
                currChar = s[front]
                if charToCount.get(currChar,0) == 0 and uniqueCharCount == k:
                    break
                count = countChar(currChar)
                if count == 1:
                    uniqueCharCount += 1
                front += 1
            
            if uniqueCharCount <= k or front == length:
                maxLength = max(maxLength, front - back)
                while uniqueCharCount >= k and back < front:
                    char = s[back]
                    charToCount[char] -= 1
                    if charToCount[char] == 0:
                        uniqueCharCount -= 1
                    back += 1
        return maxLength

s = Solution()
print(s.lengthOfLongestSubstringKDistinct("abaccc", 2)==4)
print(s.lengthOfLongestSubstringKDistinct("asdfaglakdflqjerquerojalkfjajfajfdkakjasdlfkjqoherkhafljlajdhfaslfqehr", 0))
print(s.lengthOfLongestSubstringKDistinct("asdfaglakdflqjerquerojalkfjajfajfdkakjasdlfkjqoherkhafljlajdhfaslfqehr", 1))
print(s.lengthOfLongestSubstringKDistinct("asdfaglakdflqjerquerojalkfjajfajfdkakjasdlfkjqoherkhafljlajdhfaslfqehr", 2))
print(s.lengthOfLongestSubstringKDistinct("asdfaglakdflqjerquerojalkfjajfajfdkakjasdlfkjqoherkhafljlajdhfaslfqehr", 3))
print(s.lengthOfLongestSubstringKDistinct("asdfaglakdflqjerquerojalkfjajfajfdkakjasdlfkjqoherkhafljlajdhfaslfqehr", 4))
print(s.lengthOfLongestSubstringKDistinct("aa", 2) == 2)
print(s.lengthOfLongestSubstringKDistinct("eceba", 2) == 3)
print(s.lengthOfLongestSubstringKDistinct("aaaaaa", 2) == 6)
print(s.lengthOfLongestSubstringKDistinct("aaaaaabb", 2) == 8)
print(s.lengthOfLongestSubstringKDistinct("aaaaaabbcc", 2) == 8)
print(s.lengthOfLongestSubstringKDistinct("abbcc", 2) == 4)