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
//        System.out.println(solution.minWindow("a", "a"));
//        System.out.println(solution.minWindow("a", "aa"));
    }

    private static class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> freqOfT = new HashMap<>();
            for (char c : t.toCharArray()) {
                freqOfT.put(c, freqOfT.getOrDefault(c, 0) + 1);
            }

            int n = s.length();
            int l = 0, r = 0;
            String res = "";
            Map<Character, Integer> finding = new HashMap<>(freqOfT);
            while (r < n) {
                if (finding.size() > 0) {
                    char charAtR = s.charAt(r);
                    if (finding.containsKey(charAtR)) {
                        finding.put(charAtR, finding.get(charAtR) - 1);
                        finding.remove(charAtR, 0);
                    }
                    r++;
                } else {
                    String curRes = s.substring(l, r);
                    if (res.isEmpty() || curRes.length() < res.length()) {
                        res = curRes;
                    }
                    finding = new HashMap<>(freqOfT);
                    l++;
                }
            }

            return res;
        }
    }
}
