namespace LeetCodeSolutions
{
    public class Trie
    {
        private TrieNode root;

        public Trie()
        {
            root = new TrieNode();
        }

        public void Insert(string word)
        {
            TrieNode node = root;
            foreach (var c in word)
            {
                if (!node.ContainsKey(c))
                {
                    node.Put(c, new TrieNode());
                }
                node = node.Get(c);
            }
            node.SetEnd();
        }

        private TrieNode SearchPrefix(string word)
        {
            TrieNode node = root;
            for (int i = 0; i < word.Length; i++)
            {
                char curLetter = word[i];
                if (node.ContainsKey(curLetter))
                {
                    node = node.Get(curLetter);
                }
                else
                {
                    return null;
                }
            }
            return node;
        }

        public bool Search(string word)
        {
            TrieNode node = SearchPrefix(word);
            return node != null && node.IsEnd();
        }

        public bool StartsWith(string prefix)
        {
            TrieNode node = SearchPrefix(prefix);
            return node != null;
        }
    }

    public class TrieNode
    {
        private TrieNode[] links;

        private const int R = 26;

        private bool isEnd;

        public TrieNode()
        {
            links = new TrieNode[R];
        }

        public bool ContainsKey(char ch)
        {
            return links[ch - 'a'] != null;
        }
        public TrieNode Get(char ch)
        {
            return links[ch - 'a'];
        }
        public void Put(char ch, TrieNode node)
        {
            links[ch - 'a'] = node;
        }
        public void SetEnd()
        {
            isEnd = true;
        }
        public bool IsEnd()
        {
            return isEnd;
        }
    }
}
