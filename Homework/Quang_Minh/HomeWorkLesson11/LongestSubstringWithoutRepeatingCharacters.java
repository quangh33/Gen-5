package HomeWorkLesson11;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) return 0;
        int res = 1, left = 0, right = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        count.put(s.charAt(0), 1);
        while (right < length) {
            if (count.get(s.charAt(right)) == null || count.get(s.charAt(right)) <= 1) {
                res = Math.max(res, right - left + 1);
                right++;
                if (right < length) {
                    if (count.get(s.charAt(right)) == null) count.put(s.charAt(right), 1);
                    else {
                        int freq = count.get(s.charAt(right));
                        freq++;
                        count.put(s.charAt(right), freq);
                    }
                }
            } else {
                int freq = count.get(s.charAt(left));
                freq--;
                count.put(s.charAt(left), freq);
                left++;
            }
        }
        return res;
    }
}
