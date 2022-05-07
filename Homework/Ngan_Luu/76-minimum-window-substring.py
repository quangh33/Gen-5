# https://leetcode.com/problems/minimum-window-substring/
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        dict_t=collections.Counter()
        for char in t:
            dict_t[char]+=1
        count_t=len(dict_t)
        
        res=""
        if len(t)>len(s):
            return ""
        if t in s:
            return t
        start=0
        end=0
        while end<len(s):
            char=s[end]
            if char in dict_t:
                dict_t[char]-=1
                if dict_t[char]==0:
                    count_t-=1
            while count_t==0 and start<end:
                if (end-start+1)<len(res) or res=="":
                    res=s[start:end+1]
                char=s[start]
                if char in dict_t:
                    dict_t[char]+=1
                    if dict_t[char]==1:
                        count_t+=1
                start+=1
            end+=1
        return res
