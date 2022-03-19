package HomeWorkLesson3;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        Stack stack = new Stack<Character>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (!stack.isEmpty() && (char) stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.add(s.charAt(i));
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.peek() + result;
            stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "abbbbcdef";
        System.out.println(removeDuplicates(a));
    }
}
