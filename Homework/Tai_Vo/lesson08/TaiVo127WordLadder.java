package lesson08;

import java.util.*;

/**
 * @author taivt
 * @link https://leetcode.com/problems/word-ladder/
 * @since 2022/04/15 22:15:56
 */
public class TaiVo127WordLadder {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(solution.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")));
    }

    // m: word.length, n: wordList.length
    // Space Complexity: O(m^2 * n)
    // Time Complexity: O(m^2 * n)
    private static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Map<String, List<String>> variantMap = new HashMap<>();
            for (String variant : getVariants(beginWord)) {
                List<String> rootWords = variantMap.computeIfAbsent(variant, s -> new ArrayList<>());
                rootWords.add(beginWord);
            }
            boolean hasEndWord = false;
            for (String word : wordList) {
                if (endWord.equals(word)) {
                    hasEndWord = true;
                }
                for (String variant : getVariants(word)) {
                    List<String> rootWords = variantMap.computeIfAbsent(variant, s -> new ArrayList<>());
                    rootWords.add(word);
                }
            }
            if (!hasEndWord) {
                return 0;
            }

            Map<String, List<String>> adjacencyMap = new HashMap<>();
            for (List<String> rootWords : variantMap.values()) {
                for (int i = 0; i < rootWords.size(); i++) {
                    String cur = rootWords.get(i);
                    for (int j = i + 1; j < rootWords.size(); j++) {
                        String next = rootWords.get(j);
                        List<String> curNeighbours = adjacencyMap.computeIfAbsent(cur, s -> new ArrayList<>());
                        curNeighbours.add(next);

                        List<String> nextNeighbours = adjacencyMap.computeIfAbsent(next, s -> new ArrayList<>());
                        nextNeighbours.add(cur);
                    }
                }
            }

            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            visited.add(beginWord);
            int steps = 0;
            while (!queue.isEmpty()) {
                steps++;
                int levelLength = queue.size();
                for (int i = 0; i < levelLength; i++) {
                    String current = queue.poll();
                    if (endWord.equals(current)) {
                        return steps;
                    }

                    List<String> nextLevel = new ArrayList<>();
                    List<String> neighbours = adjacencyMap.get(current);
                    for (String neighbour : neighbours) {
                        if (!visited.contains(neighbour)) {
                            nextLevel.add(neighbour);
                        }
                    }
                    visited.addAll(nextLevel);
                    queue.addAll(nextLevel);
                }
            }

            return 0;
        }

        private List<String> getVariants(String word) {
            List<String> variants = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                String variant = word.substring(0, i) + "*" + word.substring(i + 1);
                variants.add(variant);
            }
            return variants;
        }
    }
}
