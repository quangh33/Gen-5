package HomeWorkLesson3;

import java.util.Stack;

public class EvaluateReversePolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int tempResult;
            switch (token) {
                case "+": {
                    tempResult = stack.pop() + stack.pop();
                    stack.push(tempResult);
                    break;
                }
                case "-": {
                    tempResult = stack.pop() - stack.pop();
                    stack.push(tempResult);
                    break;
                }
                case "*": {
                    tempResult = stack.pop() * stack.pop();
                    stack.push(tempResult);
                    break;
                }
                case "/": {
                    tempResult = ((int)(1.00 / stack.pop()) * stack.pop());
                    stack.push(tempResult);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                    break;
                }
            }
        }
        return stack.pop();
    }
}
