from struct import calcsize
from typing import List


def isOperator(char: str) -> bool:
    return char == '+' or char == '-' or char == '*' or char == '/'

def calculate(operand1: int, operand2: int, operator: str) -> int:
    if operator == '+':
        return operand1 + operand2
    if operator == '-':
        return operand1 - operand2
    if operator == '*':
        return operand1 * operand2
    if operator == '/':
        return int(operand1 / operand2)

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if not isOperator(token):
                stack.append(int(token))
            else:
                operand2 = stack.pop()
                operand1 = stack.pop()
                operator = token
                stack.append(calculate(operand1, operand2, operator))
        return stack[0]

s = Solution()
print(s.evalRPN(["2","1","+","3","*"]) == 9)
print(s.evalRPN(["4","13","5","/","+"]) == 6)
print(s.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"]) == 22)
