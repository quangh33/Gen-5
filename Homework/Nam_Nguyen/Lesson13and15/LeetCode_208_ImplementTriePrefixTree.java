package Homework.Nam_Nguyen.Lesson13and15;

class Trie {
    
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
    
    public void insert(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];
        }
        currNode.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(currNode.children[index] == null)    return false;
            currNode = currNode.children[index];
        }
        return currNode.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(currNode.children[index] == null)    return false;
            currNode = currNode.children[index];
        }
        return true;
    }
}

public class LeetCode_208_ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        // trie.insert("apple");
        // System.out.println(trie.search("apple"));   // return True
        // System.out.println(trie.search("app"));     // return False
        // System.out.println(trie.startsWith("app")); // return True
        // trie.insert("app");
        // System.out.println(trie.search("app")); // return True
        System.out.println(trie.startsWith("a"));
    }
}
