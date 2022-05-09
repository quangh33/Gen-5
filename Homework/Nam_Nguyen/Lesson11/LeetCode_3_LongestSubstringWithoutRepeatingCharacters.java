package Homework.Nam_Nguyen.Lesson11;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_3_LongestSubstringWithoutRepeatingCharacters {

    Map<Character, Integer> frequencies = new HashMap<>();

    public int lengthOfLongestSubstring(String s) {
        int res = 1;
        int length = s.length();
        if(length == 0) return 0;
        int left = 0, right = 0;
        frequencies.put(s.charAt(0), 1);
        while(right < length) {
            if(frequencies.getOrDefault(s.charAt(right), 0) <= 1) {
                res = Math.max(right - left + 1, res);
                right++;
                if(right < length)
                    frequencies.put(s.charAt(right), frequencies.getOrDefault(s.charAt(right), 0) + 1);
            }else {
                frequencies.put(s.charAt(left), frequencies.get(s.charAt(left)) - 1);
                left++; 
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_3_LongestSubstringWithoutRepeatingCharacters prob = new LeetCode_3_LongestSubstringWithoutRepeatingCharacters();
        String s = "abcdef";
        System.out.println(prob.lengthOfLongestSubstring(s));
    }
    
}
