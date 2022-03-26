package HomeWorkLesson3;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && matchBrackets((char) stack.peek(), s.charAt(i))) {
                stack.pop();
                continue;
            }
            stack.add(s.charAt(i));
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    public static boolean matchBrackets(char openBracket, char closeBracket) {
        if (openBracket == '(' && closeBracket == ')') return true;
        if (openBracket == '[' && closeBracket == ']') return true;
        if (openBracket == '{' && closeBracket == '}') return true;
        return false ;
    }

    public static void main(String[] args) {
        String a = "({}[]()(){})";
        System.out.println(isValid(a));

    }
}
