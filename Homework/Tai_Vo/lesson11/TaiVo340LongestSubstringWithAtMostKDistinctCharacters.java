package lesson11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * @since 2022/05/08 23:07:13
 */
public class TaiVo340LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("a", 0));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("", 1));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (k == 0) {
                return 0;
            }
            int n = s.length();
            Map<Character, Integer> freq = new HashMap<>();
            int res = 0;
            int l = 0, r = 0;

            while (r < n) {
                char charAtR = s.charAt(r);
                if (freq.containsKey(charAtR) || freq.size() < k) {
                    int freqOfR = freq.getOrDefault(charAtR, 0);
                    freq.put(charAtR, freqOfR + 1);
                    res = Math.max(res, r - l + 1);
                    r++;
                } else {
                    char charAtL = s.charAt(l);
                    int freqOfL = freq.getOrDefault(charAtL, 0);
                    freq.put(charAtL, freqOfL - 1);
                    freq.remove(charAtL, 0);    // remove if the frequency of L is 0
                    l++;
                }
            }

            return res;
        }
    }
}
