class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        length1 = len(text1)
        length2 = len(text2)
        text1 = ' ' + text1
        text2 = ' ' + text2
        arr = [[0] * (length2 + 1) for _ in range(length1 + 1)]
        for i in range(1, length1 + 1):
            for j in range(1, length2 + 1):
                if text1[i] == text2[j]:
                    arr[i][j] = arr[i - 1][j - 1] + 1
                else:
                    arr[i][j] = max(arr[i - 1][j], arr[i][j - 1])
        return arr[-1][-1]

s = Solution()
print(s.longestCommonSubsequence("abcde","ace"))
print(s.longestCommonSubsequence("abc", "abc"))
print(s.longestCommonSubsequence("abc", "def"))
print(s.longestCommonSubsequence("abcd", "def"))
print(s.longestCommonSubsequence("abcqwe", "defabc"))