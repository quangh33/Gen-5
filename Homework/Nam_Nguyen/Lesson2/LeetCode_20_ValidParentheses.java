package Homework.Nam_Nguyen.Lesson2;

import java.util.Stack;

public class LeetCode_20_ValidParentheses {

    static Stack<Character> stackOfParenthese = new Stack<>();

    public static boolean isValid(String s) {

        if(s.length()%2 != 0)   return false;

        for (char character : s.toCharArray()) {
            if(character == '{' || character == '[' || character == '(') {
                stackOfParenthese.push(character);
            }else {
                if(stackOfParenthese.isEmpty()) return false;
                char top = stackOfParenthese.peek();
                if((character == '}' && top == '{') || (character == ']' && top == '[') || (character == ')' && top == '(')) {
                    stackOfParenthese.pop();
                    continue;
                }
                return false;
            }
        }

        return stackOfParenthese.isEmpty();
    }
    
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println("res: "+isValid(s));
    }
}
