package lesson11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/minimum-window-substring/
 * @since 2022/05/08 23:32:42
 */
public class TaiVo76MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
        System.out.println(solution.minWindow("a", "aa"));
    }

    // n: s.length, m: t.length
    // Space Complexity: O(n + m)
    // Time Complexity: O(n + m)
    private static class Solution {
        public String minWindow(String s, String t) {
            int n = s.length();
            int l = 0;
            int r = 0;

            Map<Character, Integer> dictT = new HashMap<>();
            for (char c : t.toCharArray()) {
                dictT.put(c, dictT.getOrDefault(c, 0) + 1);
            }

            int required = dictT.size();
            int formed = 0;
            String res = "";
            Map<Character, Integer> windowFreq = new HashMap<>();
            while (r < n) {
                char charAtR = s.charAt(r);
                windowFreq.put(charAtR, windowFreq.getOrDefault(charAtR, 0) + 1);
                r++;

                if (dictT.containsKey(charAtR) && dictT.get(charAtR).equals(windowFreq.get(charAtR))) {
                    formed++;
                }

                while (formed == required) {
                    char charAtL = s.charAt(l);
                    windowFreq.put(charAtL, windowFreq.get(charAtL) - 1);
                    if (dictT.containsKey(charAtL) && windowFreq.get(charAtL) < dictT.get(charAtL)) {
                        formed--;

                        String subStr = s.substring(l, r);
                        if (res.isEmpty() || subStr.length() < res.length()) {
                            res = subStr;
                        }
                    }
                    l++;
                }
            }

            return res;
        }
    }
}
