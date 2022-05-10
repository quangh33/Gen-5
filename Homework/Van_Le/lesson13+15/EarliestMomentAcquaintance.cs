namespace LeetCodeSolutions
{
    public class EarliestMomentAcquaintance
    {
        public int EarliestAcq(int[][] logs, int n)
        {
            var sortedLog = logs.OrderBy(x => x[0]);
            UnionFind unifi = new UnionFind(n);

            foreach (int[] edge in sortedLog)
            {
                unifi.Union(edge[1], edge[2]);
                if (unifi.GetCount() == 1)
                {
                    return edge[0];
                }
            }
            return -1;
        }
    }

    public class UnionFind
    {
        int[] root;
        int[] rank;
        int count;

        public UnionFind(int size)
        {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++)
            {
                root[i] = i;
                rank[i] = 1;
            }
        }
        public int Find(int node)
        {
            if (root[node] == node)
            {
                return node;
            }
            return root[node] = Find(root[node]);
        }

        public void Union(int nodeA, int nodeB)
        {
            int rootA = Find(nodeA);
            int rootB = Find(nodeB);

            if (rootA != rootB)
            {
                if (rank[rootA] > rank[rootB])
                {
                    root[rootB] = rootA;
                }
                else if (rank[rootB] > rank[rootA])
                {
                    root[rootA] = rootB;
                }
                else
                {
                    root[rootB] = rootA;
                    rank[rootA] += 1;
                }
                count--;
            }
        }

        public int GetCount()
        {
            return count;
        }
    }
}
