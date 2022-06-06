package Homework.Nam_Nguyen.Lesson13and15;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1268_SearchSuggestionsSystem {

    public class Trie {
        public static final int SIZE = 26;

        class TrieNode {
            TrieNode[] children;
            boolean isEnd;

            public TrieNode() {
                children = new TrieNode[SIZE];
                isEnd = false;
                for (int i = 0; i < children.length; i++) {
                    children[i] = null;
                }
            }
        }

        TrieNode root = new TrieNode();

        public void insert(String key) {
            TrieNode currNode = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (currNode.children[index] == null) {
                    currNode.children[index] = new TrieNode();
                }
                currNode = currNode.children[index];
            }
            currNode.isEnd = true;
        }

        public boolean search(String key) {

            TrieNode currNode = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (currNode.children[index] == null)
                    return false;
                currNode = currNode.children[index];
            }
            return currNode.isEnd;
        }

        public List<String> startWith(String key) {

            List<String> res = new ArrayList<>();

            TrieNode currNode = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (currNode.children[index] == null)
                    return res;
                currNode = currNode.children[index];
            }
            DFS(key, res, currNode);
            return res;
        }

        public void DFS(String key, List<String> res, TrieNode pointer) {
            if (pointer.isEnd) {
                if (res.size() < 3) {
                    res.add(key);
                }
            }
            for (int i = 0; i < pointer.children.length; i++) {
                if (pointer.children[i] != null) {
                    int character = i + 'a';
                    DFS(key + (char) character, res, pointer.children[i]);
                }
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Trie trie = new Trie();

        for (int i = 1; i <= searchWord.length(); i++) {
            res.add(trie.startWith(searchWord.substring(0, i)));
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode_1268_SearchSuggestionsSystem prob = new LeetCode_1268_SearchSuggestionsSystem();
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";
        prob.suggestedProducts(products, searchWord);
    }
}
