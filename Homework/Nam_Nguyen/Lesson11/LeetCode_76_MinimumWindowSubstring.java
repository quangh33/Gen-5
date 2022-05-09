package Homework.Nam_Nguyen.Lesson11;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_76_MinimumWindowSubstring {

    Map<Character, Integer> frequenciesOfStringT = new HashMap<>();
    Map<Character, Integer> frequenciesOfStringS = new HashMap<>();

    public String minWindow(String s, String t) {
        String res = "";
        int minLength = s.length() + 1;
        int sLen = s.length();
        int tLen = t.length();

        for (int i = 0; i < tLen; i++) {
            frequenciesOfStringT.put(t.charAt(i), frequenciesOfStringT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = 0;
        StringBuilder currentResult = new StringBuilder();
        while(l < sLen) {
            if(!isValid(s, l, r)){
                if(r < sLen) {
                    frequenciesOfStringS.put(s.charAt(r), frequenciesOfStringS.getOrDefault(s.charAt(r), 0) + 1);
                    currentResult.append(s.charAt(r));
                    r++;
                }
                else{
                    break;
                }
            }else{
                if(currentResult.length() < minLength) {
                    res = currentResult.toString();
                    minLength = res.length();
                }
                if(currentResult.length() > 0)
                    currentResult.deleteCharAt(0);
                frequenciesOfStringS.put(s.charAt(l), frequenciesOfStringS.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
        }
        return res;
    }

    private boolean isValid(String s, int left, int right) {
        if(frequenciesOfStringS.size() < frequenciesOfStringT.size())   return false;
        for(Map.Entry<Character, Integer> entry : frequenciesOfStringT.entrySet()){
            if(frequenciesOfStringS.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "a", t = "aa";
        LeetCode_76_MinimumWindowSubstring solution = new LeetCode_76_MinimumWindowSubstring();
        System.out.println("res "+solution.minWindow(s, t));
    }
}
