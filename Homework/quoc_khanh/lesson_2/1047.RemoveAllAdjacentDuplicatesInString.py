from typing import List


TOP = -1
EMPTY_STACK = ""

def isEmpty(stack: str) -> bool:
    return len(stack) == 0

def top(stack: str) -> str:
    if isEmpty(stack):
        return EMPTY_STACK
    else:
        return stack[TOP]

def push(stack: str, value: str) -> str:
    return stack + value

def pop(stack: str) -> str:
    if not isEmpty(stack):
        return stack[:TOP]
    return EMPTY_STACK

class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack = EMPTY_STACK
        for ch in s:
            if ch != top(stack):
                stack = push(stack, ch)
            else:
                stack = pop(stack)
        return stack

s = Solution()
print(s.removeDuplicates("abbaca") == "ca")
print(s.removeDuplicates("azxxzy") == "ay")
print(s.removeDuplicates("abcdef") == "abcdef")
