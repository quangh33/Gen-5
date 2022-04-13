package HomeWorkLesson7Part2;

import javafx.util.Pair;

import java.util.*;

public class WorldLadder {
    private class StringNLevel {
        String value;
        int level;

        StringNLevel(String value, int level) {
            this.value = value;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<StringNLevel> queue = new ArrayDeque();
        queue.add(new StringNLevel(beginWord, 1));
        List<String> visited = new ArrayList<>();
        while (true) {
            if(queue.size() == 0) break;
            StringNLevel currentNode = queue.poll();
            String currentWord = currentNode.value;
            int currentLevel = currentNode.level;
            if (currentNode.value.equals(endWord)) return currentLevel;
            visited.add(currentWord);
            for (String nextWord : wordList) {
                if (!visited.contains(nextWord) && isValid(currentWord, nextWord)) {
                    queue.add(new StringNLevel(nextWord, currentLevel + 1));
                }
            }
        }
        return 0;
    }

    public boolean isValid(String s1, String s2) {
        int numOfDiff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) numOfDiff ++;
            if(numOfDiff > 1) return false;
        }
        return true;
    }
}
