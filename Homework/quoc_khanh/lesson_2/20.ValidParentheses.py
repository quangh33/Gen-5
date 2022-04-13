from queue import Empty
from typing import List

TOP = -1
EMPTY = ""
openToClose = {
    '{': '}',
    '[': ']',
    '(': ')'
}

def isOpenBracket(bracket: str) -> bool:
    return openToClose.get(bracket, EMPTY) != EMPTY

def isEmpty(stack: List[str]) -> bool:
    return len(stack) == 0

def top(stack: List[str]) -> str:
    if isEmpty(stack):
        return EMPTY
    else:
        return stack[TOP]

def isMatched(openBracket: str, closeBracket: str) -> bool:
    return openToClose.get(openBracket, EMPTY) == closeBracket

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for bracket in s:
            if isOpenBracket(bracket):
                stack.append(bracket)
            else:
                if isMatched(top(stack), bracket):
                    stack.pop()
                else:
                    return False
        return len(stack) == 0

s = Solution()
print(s.isValid('{}[]()') == True)
print(s.isValid('([{}])') == True)
print(s.isValid('({[}])') == False)
print(s.isValid('{') == False)
print(s.isValid(']') == False)
print(s.isValid('[]') == True)