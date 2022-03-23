https://leetcode.com/problems/valid-parentheses/
class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]
        for char in s:
            if char in ['(','{','[']:
                stack.append(char)
            else:
                if len(stack)>0:
                    if stack[-1]+char in ['{}','()','[]']:
                        stack.pop()
                    else:
                        return False
                else:
                    return False
        if len(stack)==0:
            return True
