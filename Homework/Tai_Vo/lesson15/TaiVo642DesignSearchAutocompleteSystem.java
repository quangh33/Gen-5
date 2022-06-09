package lesson15;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author taivt
 * @link https://leetcode.com/problems/design-search-autocomplete-system
 * @since 2022/05/19 20:39:56
 */
public class TaiVo642DesignSearchAutocompleteSystem {

    public static void main(String[] args) {
        AutocompleteSystem obj = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        System.out.println(obj.input('i')); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
        System.out.println(obj.input(' ')); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
        System.out.println(obj.input('a')); // return []. There are no sentences that have prefix "i a".
        System.out.println(obj.input('#')); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.

        AutocompleteSystem obj2 = new AutocompleteSystem(new String[]{"ai", "ab", "iroman", "i love leetcode"}, new int[]{5, 5, 2, 2});
        System.out.println(obj2.input('a'));
        System.out.println(obj2.input('i'));
        System.out.println(obj2.input('#'));
        System.out.println(obj2.input('a'));
    }

    private static class AutocompleteSystem {

        private static class RankTrie {

            private final Map<Character, RankTrie> children = new HashMap<>();
            private final Set<String> suggestions = new HashSet<>();

            public void insert(String word) {
                RankTrie iter = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    iter = iter.children.computeIfAbsent(c, character -> new RankTrie());
                    iter.suggestions.add(word);
                }
            }

            public RankTrie startsWith(String prefix) {
                RankTrie iter = this;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    iter = iter.children.get(c);
                    if (iter == null) {
                        return null;
                    }
                }
                return iter;
            }
        }

        private final RankTrie rankTrie = new RankTrie();
        private final StringBuilder searchString = new StringBuilder();
        private final Map<String, Integer> frequency = new HashMap<>();

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                String sentence = sentences[i];
                int time = times[i];
                rankTrie.insert(sentence);
                frequency.put(sentence, time);
            }
        }

        public List<String> input(char c) {
            if (c == '#') {
                String word = searchString.toString();
                rankTrie.insert(word);
                searchString.setLength(0);
                Integer freq = frequency.getOrDefault(word, 0);
                frequency.put(word, ++freq);
                return List.of();
            }

            searchString.append(c);
            return getSuggestions();
        }

        private List<String> getSuggestions() {
            String word = searchString.toString();
            RankTrie rankTrie = this.rankTrie.startsWith(word);
            if (rankTrie == null) {
                return List.of();
            }

            Comparator<String> comparator = Comparator.comparing(suggestion -> -frequency.get(suggestion));   // Compare by rank
            comparator = comparator.thenComparing(suggestion -> suggestion);    // compare by ASCII-code
            return rankTrie.suggestions.stream()
                    .sorted(comparator)
                    .limit(3)
                    .collect(Collectors.toList());
        }
    }
}
