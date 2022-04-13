https://leetcode.com/problems/evaluate-reverse-polish-notation/
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        for token in tokens:
            if token not in ['+','-','*','/']:
                stack.append(int(token))
            else:
                if len(stack)<2:
                    return False
                else:
                    a=stack.pop()
                    b=stack.pop()
                    if token == '+':
                        stack.append(a+b)
                    elif token == '-':
                        stack.append(b-a)
                    elif token =='*':
                        stack.append(a*b)
                    else:
                        stack.append(int(b/a))
        return stack[0]
