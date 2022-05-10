using System.Text;

namespace LeetCodeSolutions
{
    public class AutocompleteSystem
    {
        StringBuilder? preFixSoFar = null;
        TrieForAutoComplete? Trie = null;
        List<KeyValuePair<string, int>>? matchesFound = null;
        TrieNode? currNode = null;

        public AutocompleteSystem(string[] sentences, int[] times)
        {
            preFixSoFar = new StringBuilder();
            Trie = new TrieForAutoComplete();
            currNode = Trie.root;
            for (int i = 0; i < times.Length; i++)
                Trie.Add(sentences[i], times[i]);
        }

        public IList<string> Input(char c)
        {
            if (c == '#')
            {
                if (!currNode.isWord)
                {
                    currNode.isWord = true;
                    currNode.times = 1;
                }
                else
                    currNode.times++;

                currNode = Trie.root;
                preFixSoFar = new StringBuilder();
                return new List<string>();
            }
            else
            {
                if (!currNode.children.ContainsKey(c))
                {
                    currNode.children.Add(c, new TrieNode());
                    currNode = currNode.children[c];
                    return new List<string>();
                }

                currNode = currNode.children[c];
                matchesFound = new List<KeyValuePair<string, int>>();

                preFixSoFar.Append(c);

                Trie.SearchMatch(currNode, preFixSoFar.ToString(), matchesFound);   
                matchesFound.Sort(new AutoCompleteFrequency());                     
                List<string> result = new List<string>();
                for (int i = 0; i < matchesFound.Count && i < 3; i++)               
                    result.Add(matchesFound[i].Key);

                return result;
            }
        }
    }

    public class AutoCompleteFrequency : IComparer<KeyValuePair<string, int>>
    {
        public int Compare(KeyValuePair<string, int> kvp1, KeyValuePair<string, int> kvp2)
        {
            if (kvp1.Value != kvp2.Value)          
                return (kvp1.Value > kvp2.Value) ? -1 : 1;
            return kvp1.Key.CompareTo(kvp2.Key);   
        }
    }
    public class TrieNode
    {
        public Dictionary<char, TrieNode> children = null;
        public bool isWord = false;
        public int times = 0;
        public TrieNode() => children = new Dictionary<char, TrieNode>();
    }
    public class TrieForAutoComplete
    {
        public TrieNode root = null;
        public TrieForAutoComplete() => root = new TrieNode();

        // Insert for 'Search AutoComplete System'
        public void Add(string sentence, int count)
        {
            TrieNode temp = root;
            for (int i = 0; i < sentence.Length; i++)
            {
                if (!temp.children.ContainsKey(sentence[i])) temp.children.Add(sentence[i], new TrieNode());
                temp = temp.children[sentence[i]];
            }
            if (!temp.isWord)
            {
                temp.isWord = true;   
                temp.times = count;   
            }
            else
                temp.times++;         
        }

        public void SearchMatch(TrieNode currNode, string prefixSoFar, List<KeyValuePair<string, int>> matchesFound)
        {
            if (currNode.isWord)    
                matchesFound.Add(new KeyValuePair<string, int>(prefixSoFar, currNode.times));
            foreach (var possibleWord in currNode.children)
                SearchMatch(possibleWord.Value, prefixSoFar + possibleWord.Key, matchesFound);
        }
    }
}
