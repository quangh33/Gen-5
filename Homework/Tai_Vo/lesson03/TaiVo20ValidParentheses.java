package lesson03;

import java.util.Stack;

/**
 * @author taivt
 * @link https://leetcode.com/problems/valid-parentheses/
 * @since 2022/03/22 19:41:40
 */
public class TaiVo20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char bracket = s.charAt(i);
                if (isOpenBrackets(bracket)) {
                    stack.push(bracket);
                    continue;
                }

                if (!stack.isEmpty() && isPairBrackets(stack.peek(), bracket)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }

        private boolean isOpenBrackets(char c) {
            return c == '(' || c == '{' || c == '[';
        }

        private boolean isPairBrackets(char open, char close) {
            switch (open) {
                case '(':
                    return close == ')';
                case '{':
                    return close == '}';
                case '[':
                    return close == ']';
            }
            return false;
        }
    }
}
