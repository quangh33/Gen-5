package lesson15;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/implement-trie-prefix-tree/
 * @since 2022/05/18 21:02:20
 */
public class TaiVo208ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    // Space Complexity: O(total number of chars of all words)
    // Time Complexity: O(len(word) for each operation)
    private static class Trie {
        private boolean ended;
        private final Map<Character, Trie> children = new HashMap<>();

        public void insert(String word) {
            Trie iter = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                iter = iter.children.computeIfAbsent(c, character -> new Trie());
                if (i == word.length() - 1) {
                    iter.ended = true;
                }
            }
        }

        public boolean search(String word) {
            Trie iter = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                iter = iter.children.get(c);
                if (iter == null) {
                    return false;
                }

                if (i == word.length() - 1 && iter.ended) {
                    return true;
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            Trie iter = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                iter = iter.children.get(c);
                if (iter == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
