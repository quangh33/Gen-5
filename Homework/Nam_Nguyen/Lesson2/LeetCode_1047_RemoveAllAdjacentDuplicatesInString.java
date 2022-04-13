package Homework.Nam_Nguyen.Lesson2;

import java.util.Stack;

public class LeetCode_1047_RemoveAllAdjacentDuplicatesInString {

    static Stack<Character> stackOfCharacter = new Stack<>();
    
    public static String removeDuplicates(String s) {

        for (char character: s.toCharArray()) {
            char top = '\0';
            if(!stackOfCharacter.empty()) top = stackOfCharacter.peek();
            if(character == top) {
                stackOfCharacter.pop();
            }else {
                stackOfCharacter.add(character);
            }
        }

        StringBuilder result = new StringBuilder("");
        while(!stackOfCharacter.isEmpty()) {
            result.append(stackOfCharacter.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "azxxzy";
        String res = removeDuplicates(s);
    }
}
