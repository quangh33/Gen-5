package Homework.Nam_Nguyen.Lesson2;

import java.util.Stack;

public class LeetCode_150_EvaluateReversepolishNotation {

    static Stack<Integer> calculationStack = new Stack<>();
    
    public static int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if(isSymbol(token)){
                int top = calculationStack.pop();
                int underTop = calculationStack.pop();
                int result = 0;
                switch(token) {
                    case "+":
                        result = underTop + top;
                        break;
                    case "-":
                        result = underTop - top;
                        break;
                    case "*":
                        result = underTop * top;
                        break;
                    case "/":
                        result = underTop / top;
                }
                calculationStack.push(result);
            } else {
                calculationStack.push(Integer.parseInt(token));
            }
        }
        return calculationStack.pop();
    }

    public static boolean isSymbol(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int result = evalRPN(tokens);
        System.out.println("result: "+result);
    }
}
