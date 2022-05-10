namespace LeetCodeSolutions
{
    public class OptimizeWaterDistributionVillage
    {
        public int MinCostToSupplyWater(int n, int[] wells, int[][] pipes)
        {
            List<int[]> orderedEdges = new List<int[]>();

            for (int i = 0; i < wells.Length; i++)
            {
                int[] edge = new int[] { 0, i + 1, wells[i] };
                orderedEdges.Add(edge);
            }

            foreach (int[] pipe in pipes)
            {
                orderedEdges.Add(pipe);
            }

            orderedEdges.Sort((a, b) => a[2].CompareTo(b[2]));

            UnionFind unf = new UnionFind(n);
            int totalCost = 0;
            foreach (int[] edge in orderedEdges)
            {
                int house1 = edge[0];
                int house2 = edge[1];
                int cost = edge[2];
                if (unf.Union(house1, house2))
                {
                    totalCost += cost;
                }
            }

            return totalCost;
        }
    }
    public class UnionFind
    {
        private int[] root;
        private int[] rank;

        public UnionFind(int size)
        {
            this.root = new int[size + 1];
            this.rank = new int[size + 1];

            for (int i = 0; i < size + 1; i++)
            {
                this.root[i] = i;
                this.rank[i] = 1;
            }
        }

        public int Find(int x)
        {
            if (x == this.root[x])
            {
                return x;
            }

            return this.root[x] = this.Find(this.root[x]);
        }

        public bool Union(int x, int y)
        {
            int rootX = this.Find(x);
            int rootY = this.Find(y);

            if (rootX != rootY)
            {
                if (this.rank[rootX] < this.rank[rootY])
                {
                    this.root[rootX] = rootY;
                }
                else if (this.rank[rootY] < this.rank[rootX])
                {
                    this.root[rootY] = rootX;
                }
                else
                {
                    this.root[rootY] = rootX;
                    this.rank[rootX]++;
                }

                return true;
            }

            return false;
        }
    }
}