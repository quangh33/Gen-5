package HomeWorkLesson13_15;

import java.util.*;

public class DesignSearchAutoCompleteSystem {
    class AutocompleteSystem {

        class Tuple {
            String str;
            int count;
            public Tuple(String s, int c) {
                str = s;
                count = c;
            }
        }

        // implement Trie
        class Trie {
            class TrieNode {
                char val;
                Map<Character, TrieNode> children;
                int count;

                public TrieNode(char c) {
                    val = c;
                    children = new HashMap<>();
                    count = -1;
                }
            }

            TrieNode root;

            public Trie() {
                root = new TrieNode('*');
            }

            // add a strin to Trie
            public void insert(String str, int count) {
                TrieNode node = root;
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    node.children.putIfAbsent(c, new TrieNode(c));
                    node = node.children.get(c);
                }
                node.count = ((node.count == -1) ? count : (node.count + count));
            }

            // find strings with given prefix
            public List<Tuple> findPrefix(String prefix) {
                TrieNode node = root;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    node.children.putIfAbsent(c, new TrieNode(c));
                    node = node.children.get(c);
                }

                List<Tuple> res = new LinkedList<>();
                backtrack(node, new StringBuilder(prefix), res);
                return res;
            }

            // utility function for findPrefix(), backtracking used
            public void backtrack(TrieNode node, StringBuilder sb, List<Tuple> res) {
                if (node == null) {
                    return;
                }

                if (node.count > 0) {
                    res.add(new Tuple(sb.toString(), node.count));
                }

                for (char next : node.children.keySet()) {
                    sb.append(next);
                    backtrack(node.children.get(next), sb, res);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        Trie records;
        StringBuilder prefix;

        public AutocompleteSystem(String[] sentences, int[] times) {
            records = new Trie();
            for (int i = 0; i < times.length; i++) {
                records.insert(sentences[i], times[i]);
            }
            prefix = new StringBuilder();
        }

        public List<String> input(char c) {
            if (c == '#') {
                records.insert(prefix.toString(), 1);
                prefix.setLength(0);
                return new LinkedList<String>();
            }

            prefix.append(c);

            // construct a min-heap to keep top-3 recommend
            PriorityQueue<Tuple> pq = new PriorityQueue<>((o1, o2) -> {
                return (o1.count == o2.count) ? o2.str.compareTo(o1.str) : o1.count - o2.count;
            });

            // find all options with current prefix and add to min-heap
            List<Tuple> options = records.findPrefix(prefix.toString());
            for (Tuple opt : options) {
                pq.offer(opt);
                if (pq.size() > 3)
                    pq.poll();
            }

            LinkedList<String> res = new LinkedList<>();
            while (pq.size() > 0) {
                res.addFirst(pq.poll().str);
            }

            return res;
        }
    }
}
