package Homework.Nam_Nguyen.Lesson11;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_340_LongestSubstringWithAtMostKDistinctCharacters {

    Map<Character, Integer> frequencies = new HashMap<>();

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        int length = s.length();
        if(k == 0 || length == 0) return 0;
        int left = 0, right = 0;
        frequencies.put(s.charAt(0), 1);
        while(right < length) {
            if(frequencies.size() <= k) {
                res = Math.max(right - left + 1, res);
                right++;
                if(right < length) {
                    frequencies.put(s.charAt(right), frequencies.getOrDefault(s.charAt(right), 0) + 1);
                }
            }else {
                frequencies.put(s.charAt(left), frequencies.get(s.charAt(left)) - 1);
                if(frequencies.get(s.charAt(left)) == 0) {
                    frequencies.remove(s.charAt(left));
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_340_LongestSubstringWithAtMostKDistinctCharacters prob = new LeetCode_340_LongestSubstringWithAtMostKDistinctCharacters();
        String s = "aa";
        int k = 1;
        System.out.println(prob.lengthOfLongestSubstringKDistinct(s, k));
    }
    
}
