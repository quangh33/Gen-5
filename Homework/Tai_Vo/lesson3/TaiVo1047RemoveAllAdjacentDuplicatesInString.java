package lesson3;

import java.util.Stack;

/**
 * @author taivt
 * @link https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * @since 2022/03/22 20:30:25
 */
public class TaiVo1047RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
        System.out.println(solution.removeDuplicates("azxxzy"));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char charAtI = s.charAt(i);
                if (!stack.isEmpty() && stack.peek() == charAtI) {
                    stack.pop();
                } else {
                    stack.push(charAtI);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : stack) {
                stringBuilder.append(character);
            }
            return stringBuilder.toString();
        }
    }
}
