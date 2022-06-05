# https://leetcode.com/problems/longest-substring-without-repeating-characters
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)<2:
            return len(s)
        slow=0
        fast=0
        res=1
        while fast+1<len(s):
            if s[fast+1] not in s[slow:fast+1]:
                fast+=1
                res=max(res,fast-slow+1)
            else:
                while s[fast+1] in s[slow:fast+1] and slow<=fast:
                    slow+=1
                fast+=1
        return res