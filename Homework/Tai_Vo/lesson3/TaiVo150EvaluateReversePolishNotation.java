package lesson3;

import java.util.Stack;

/**
 * @author taivt
 * @link https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * @since 2022/03/22 20:46:41
 */
public class TaiVo150EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {

        public int evalRPN(String[] tokens) {
            Stack<Integer> operandStack = new Stack<>();
            for (String token : tokens) {
                if (isOperator(token)) {
                    Integer operandAfter = operandStack.pop();
                    Integer operandBefore = operandStack.pop();
                    Integer result = calculate(operandBefore, operandAfter, token);
                    operandStack.push(result);
                } else {
                    operandStack.push(Integer.valueOf(token));
                }
            }
            return operandStack.pop();
        }

        private boolean isOperator(String input) {
            return "+".equals(input) || "-".equals(input) || "*".equals(input) || "/".equals(input);
        }

        private Integer calculate(Integer operand1, Integer operand2, String operator) {
            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                case "/":
                    return operand1 / operand2;
            }
            return -1;
        }
    }
}
