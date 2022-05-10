public class WordFilter
{
    private Trie prefixTrie = new Trie(), suffixTrie = new Trie();
    
    public WordFilter(string[] words)
    {
        for(int i = 0; i < words.Length; i++)
        {
            string word = words[i];
            prefixTrie.AddWord(word, i);
            suffixTrie.AddWord(word.Reverse(), i);
        }
    }

    public int F(string prefix, string suffix)
    {
        Trie t1 = prefixTrie.FindSubTrie(prefix), t2 = suffixTrie.FindSubTrie(suffix.Reverse());
        if(t1 is null || t2 is null) return -1;
        List<int> intersection = t1.GetValues(new List<int>()).Intersect(t2.GetValues(new List<int>())).ToList();
        return intersection.Count > 0 ? intersection.Max() : -1;
    }
}

public class Trie
{
    public Trie[] children = new Trie[26];
    public int? value;
    
    public void AddWord(IEnumerable<char> word, int value)
    {
        Trie trie = this;
        foreach(char c in word)
        {
            int trieIndex = c-'a';
            trie = trie.children[trieIndex] ?? (trie.children[trieIndex] = new Trie());
        }
        trie.value = value;
    }
    
    public Trie FindSubTrie(IEnumerable<char> prefix)
    {
        Trie trie = this;
        foreach(char c in prefix)
        {
            if(trie is null) return null;
            trie = trie.children[c-'a'];
        }
        return trie;
    }
    
    public List<int> GetValues(List<int> vals)
    {
        if(value.HasValue) vals.Add(value.Value);
        foreach(Trie child in children.Where(x => x != null)) child.GetValues(vals);
        return vals;
    }
}