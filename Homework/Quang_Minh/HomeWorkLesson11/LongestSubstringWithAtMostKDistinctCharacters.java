package HomeWorkLesson11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Set<Character> set = new HashSet<>();
        HashMap<Character, Integer> count = new HashMap<>();
        int length = s.length();
        if (length == 0) return 0;
        int res = 0, i = 0, j = 0;
        set.add(s.charAt(0));
        count.put(s.charAt(0), 1);
        while (i < length) {
            if (set.size() <= k) {
                res = Math.max(res, i - j + 1);
                i++;
                if (i < length) {
                    set.add(s.charAt(i));
                    if (count.get(s.charAt(i)) == null) count.put(s.charAt(i), 1);
                    else {
                        int freq = count.get(s.charAt(i));
                        freq++;
                        count.put(s.charAt(i), freq);
                    }
                }
            } else {
                int freq = count.get(s.charAt(j));
                freq--;
                count.put(s.charAt(j), freq);
                if (count.get(s.charAt(j)) == 0) set.remove(s.charAt(j));
                j++;
            }
        }
        return res;
    }
}
