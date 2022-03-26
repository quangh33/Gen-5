package HomeWorkLesson3;

import java.util.Stack;

public class EvaluateReversePolish {
    public static int evalRPN(String[] tokens) {
        String operation = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operation.contains(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(calculateWithToken(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static int calculateWithToken(int a, int b, String token) {
        switch (token) {
            case "+": {
                return a + b;
            }
            case "-": {
                return -(a - b);
            }
            case "*": {
                return a * b;
            }
            case "/": {
                return (int) ((1.00 / a) * b);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] a = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(a));
    }
}
