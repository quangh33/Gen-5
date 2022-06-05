package lesson11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @since 2022/05/08 19:49:53
 */
public class TaiVo3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("1"));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Map<Character, Integer> freq = new HashMap<>();
            int res = 0;
            int l = 0, r = 0;

            while (r < n) {
                char charAtR = s.charAt(r);
                int freqOfR = freq.getOrDefault(charAtR, 0);
                if (freqOfR < 1) {
                    freq.put(charAtR, freqOfR + 1);
                    res = Math.max(res, r - l + 1);
                    r++;
                } else {
                    char charAtL = s.charAt(l);
                    int freqOfL = freq.getOrDefault(charAtL, 0);
                    freq.put(charAtL, freqOfL - 1);
                    l++;
                }
            }

            return res;
        }
    }
}
