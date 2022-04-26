namespace LeetCodeSolutions
{
    public class WordLadder
    {
        public int LadderLength(string beginWord, string endWord, IList<string> wordList)
        {
            HashSet<string> visited = new HashSet<string>();

            Queue<string> queue = new Queue<string>();
            queue.Enqueue(beginWord);

            Node root = BuildTrie(wordList);

            int size = 0;
            string word;
            int count = 0;
            bool found = false;

            while (queue.Count > 0 && !found)
            {
                count++;
                size = queue.Count;
                while (size > 0)
                {
                    size--;
                    word = queue.Dequeue();

                    if (word == endWord) { found = true; break; }
                    if (visited.Contains(word)) { continue; }

                    visited.Add(word);

                    for (int i = 0; i < word.Length; i++)
                    {
                        FindNextStep(root, word, i, i + 1, visited, queue);
                    }
                }
            }

            return (found) ? count : 0;
        }

        private void FindNextStep(Node root, string word, int prefixLength, int postfixStartIdx,
                                  HashSet<string> visited, Queue<string> queue)
        {

            Node node = root;
            int i = 0;
            while (i < prefixLength)
            {
                if (node.Child[word[i] - 'a'] == null) { return; }
                node = node.Child[word[i] - 'a'];
                i++;
            }

            Node crnt;
            for (int j = 0; j < node.Child.Length; j++)
            {
                if (node.Child[j] == null) { continue; }

                crnt = node.Child[j];

                for (int y = postfixStartIdx; y < word.Length; y++)
                {
                    if (crnt.Child[word[y] - 'a'] == null) { crnt = null; break; }
                    crnt = crnt.Child[word[y] - 'a'];
                }

                if (crnt != null && crnt.IsEnd && !visited.Contains(crnt.Word))
                {
                    queue.Enqueue(crnt.Word);
                }
            }
        }

        private Node BuildTrie(IList<string> wordList)
        {
            Node root = new Node();
            Node node = root;

            foreach (string word in wordList)
            {
                node = root;
                foreach (char c in word)
                {
                    if (node.Child[c - 'a'] == null)
                    {
                        node.Child[c - 'a'] = new Node();
                    }
                    node = node.Child[c - 'a'];
                }
                node.Word = word;
            }

            return root;
        }

        private class Node
        {
            public Node[] Child = new Node['z' - 'a' + 1];
            public bool IsEnd { get { return Word != null; } }
            public string Word;
        }
    }
}
