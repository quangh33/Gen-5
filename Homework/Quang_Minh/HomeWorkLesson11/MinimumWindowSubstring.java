package HomeWorkLesson11;

import java.util.*;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int matchCount = 0, start = 0, end = 0, min = s.length() + 1, tLength = t.length();
        String res = "";
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < tLength; i++) {
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (end = 0; end < s.length(); end++) {
            char endCh = s.charAt(end);
            if (freq.get(endCh) != null) {
                if (freq.get(endCh) == 1) {
                    matchCount++;
                }
                freq.put(endCh, freq.get(endCh) - 1);
            }
            while (matchCount >= freq.size()) {
                int currentLength = end - start + 1;
                char startCh = s.charAt(start);
                if (currentLength < min) {
                    min = currentLength;
                    res = s.substring(start, end + 1);
                }
                if (freq.containsKey(startCh)) {
                    if (freq.get(startCh) == 0) {
                        matchCount--;
                    }
                    freq.put(startCh, freq.get(startCh) + 1);
                }
                start++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
