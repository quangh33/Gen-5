namespace LeetCodeSolutions
{
    public class LargestComponentSizeCommonFactor
    {
        private Dictionary<int, int> dict = new Dictionary<int, int>();
        private UnionFind? uf;
        public int LargestComponentSize(int[] nums)
        {
            var n = nums.Length;
            uf = new UnionFind(n);

            for (int i = 0; i < n; i++)
            {
                var num = nums[i];
                StartNewSetOrJoin(num, i, num);
                for (int j = 2; j * j <= num; j++)
                {
                    if (num % j == 0)
                    {
                        StartNewSetOrJoin(num, i, j);
                        StartNewSetOrJoin(num, i, num / j);
                    }
                }
            }

            return uf.max;
        }

        private void StartNewSetOrJoin(int num, int numIdx, int factor)
        {
            if (!dict.ContainsKey(factor))
            {
                dict[factor] = numIdx;
            }
            else
            {
                uf.Union(numIdx, dict[factor]);
            }
        }
    }

    public class UnionFind
    {
        int[] parent;
        int[] size;
        public int max;

        public UnionFind(int n)
        {
            parent = new int[n];
            size = new int[n];
            max = 1;
            for (int i = 0; i < n; i++)
            {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int Find(int n)
        {
            if (parent[n] != n)
                parent[n] = Find(parent[n]);
            return parent[n];
        }

        public void Union(int n1, int n2)
        {
            var n1_p = Find(n1);
            var n2_p = Find(n2);
            if (n1_p != n2_p)
            {
                parent[n1_p] = n2_p;
                size[n2_p] += size[n1_p];
                max = Math.Max(max, size[n2_p]);
            }

        }
    }
}
