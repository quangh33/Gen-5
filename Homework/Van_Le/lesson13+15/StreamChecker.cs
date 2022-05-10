public class StreamChecker {
    private Trie trie;
    private int longestWord;
    private StringBuilder queries;
    
    public StreamChecker(string[] words) {
        trie = new Trie();
        longestWord = 0;
        queries = new StringBuilder();
        
        foreach (var word in words) {
            longestWord = Math.Max(longestWord, word.Length);
            // Reverse word and insert into trie
            trie.Insert(new string(word.Reverse().ToArray()));                    
        }
    }
    
    public bool Query(char letter) {
        // Add letter to query buffer at the beginning 
        // so the trie is searched in reverse order
        queries.Insert(0, letter);
        if (queries.Length > longestWord) {
            queries.Remove(queries.Length - 1, 1);
        }
        // Search trie for matches
        return trie.Search(queries.ToString());
    }
}
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    public void Insert(string word) {
        var node = root;
        foreach (var ch in word) {
            if (!node.ContainsKey(ch)) {
                node.Add(ch, new TrieNode());
            }
            node = node.Get(ch);
        }
        node.SetComplete();
    }
    public bool Search(string word) {
        var node = root;
        foreach (var ch in word) {
            if (node.IsComplete()) {
                break;
            } else if (!node.ContainsKey(ch)) {
                return false;
            }
            node = node.Get(ch);
        }
        return node.IsComplete();        
    }
}

// TrieNode
public class TrieNode {
    private Dictionary<char, TrieNode> children;
    private bool isComplete;

    public TrieNode() {
        children = new Dictionary<char, TrieNode>();
    }
    public bool ContainsKey(char ch) {
        return children.ContainsKey(ch);
    }
    public TrieNode Get(char ch) {
        return children[ch];
    }
    public void Add(char ch, TrieNode node) {
        children[ch] = node;
    }
    public void SetComplete() {
        isComplete = true;
    }
    public bool IsComplete() {
        return isComplete;
    }
}