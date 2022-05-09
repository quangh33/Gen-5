class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charToIdx = {}
        lastDuplicatedIndex = -1
        maxLength = 0
        subLength = 0
        for idxInStr, char in enumerate(s):
            idx = charToIdx.get(char, -1)
            charToIdx[char] = idxInStr
            if idx > -1 and idx > lastDuplicatedIndex: # duplicated
                maxLength = max(maxLength, subLength)
                subLength = idxInStr - idx
                lastDuplicatedIndex = idx
            if idx > -1 and idx < lastDuplicatedIndex: # old data
                subLength += 1
            if idx == -1:
                subLength += 1
        return max(subLength, maxLength)

s = Solution()
print(s.lengthOfLongestSubstring("abcabcbb") == 3)
print(s.lengthOfLongestSubstring("afjqjqepgohgqjfqjfjjiofhqerqr") == 8)
print(s.lengthOfLongestSubstring("bbbbbbbb") == 1)
print(s.lengthOfLongestSubstring("abcdefgeklimo") == 8)
print(s.lengthOfLongestSubstring("pwwkew") == 3)

'''
bacedfef
'''
            