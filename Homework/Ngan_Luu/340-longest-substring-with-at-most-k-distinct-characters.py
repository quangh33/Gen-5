# https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        if k==0:
            return 0
        slow=fast=0
        res=1
        while fast+1<len(s):
            if s[fast+1] in s[slow:fast+1] or len(set(s[slow:fast+1]))<k:
                fast+=1
                res=max(res,fast-slow+1)
            else:
                while len(set(s[slow:fast+1]))>=k:
                    slow+=1
        return res