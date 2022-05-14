package Homework.Nam_Nguyen.Lesson13and15;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// LeetCode 642. Design Search Autocomplete System
public class AutocompleteSystem {

    class Pair {
        String sentence;
        int time;

        public Pair(String sentence, int time) {
            this.sentence = sentence;
            this.time = time;
        }
    }

    class Trie {
        public static final int SIZE = 27;
        TrieNode root = new TrieNode();
    
        class TrieNode {
            TrieNode[] children;
            boolean isEnd;
            int time;
            public TrieNode() {
                children = new TrieNode[SIZE];
                isEnd = false;
                for (int i = 0; i < children.length; i++) {
                    children[i] = null;
                }
            }
        }
    
        public void insert(Pair pair) {
            TrieNode currNode = root;
            for (int i = 0; i < pair.sentence.length(); i++) {
                int index = pair.sentence.charAt(i) - 'a' + 1;
                if(index < 0)   index = 0;
                if(currNode.children[index] == null) {
                    currNode.children[index] = new TrieNode();
                }
                currNode = currNode.children[index];
            }
            currNode.isEnd = true;
            if(currNode.time > 0)   currNode.time+=pair.time;
            else currNode.time = pair.time;
        }
    
        public PriorityQueue<Pair> startWith(String key) {
    
            PriorityQueue<Pair> res = new PriorityQueue<>((p1, p2) -> (p2.time - p1.time) == 0 ? (p1.sentence.compareTo(p2.sentence)) : (p2.time - p1.time));
    
            TrieNode currNode = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a' + 1;
                if(index < 0)   index = 0;
                if(currNode.children[index] == null)    return res;
                currNode = currNode.children[index];
            }
            DFS(key, res, currNode);
            return res;
        }
    
        public void DFS(String key, PriorityQueue<Pair> res, TrieNode pointer) {
            if(pointer == null) return;
            if(pointer.isEnd) {
                res.add(new Pair(key, pointer.time));
            }
            for (int i = 0; i < pointer.children.length; i++) {
                if(pointer.children[i] != null) {
                    int character = i + 'a' - 1;
                    if(character < 'a')  character = 32; // space 
                    DFS(key+(char)character, res, pointer.children[i]);
                }
            }
        }
    }

    Trie trie;
    String key = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            Pair pair = new Pair(sentences[i], times[i]);
            trie.insert(pair);
        }
    }

    public List<String> input(char c) {
        List<String> topResult = new ArrayList<>();
        PriorityQueue<Pair> allResult;
        
        if(c == '#'){
            trie.insert(new Pair(key, 1));
            key = "";
            System.out.println(topResult);
            return topResult;
        }

        key+=c;
        allResult = trie.startWith(key);

        while(!allResult.isEmpty() && topResult.size() < 3) {
            Pair pair = allResult.poll();
            topResult.add(pair.sentence);
        }

        System.out.println(topResult);
        return topResult;
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        obj.input('i'); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
        obj.input(' '); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
        obj.input('a'); // return []. There are no sentences that have prefix "i a".
        obj.input('#'); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
        obj.input('i'); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
        obj.input(' '); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
        obj.input('a'); // return []. There are no sentences that have prefix "i a".
        obj.input('#'); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
        obj.input('i'); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
        obj.input(' '); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
        obj.input('a'); // return []. There are no sentences that have prefix "i a".
        obj.input('#'); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
    }
}