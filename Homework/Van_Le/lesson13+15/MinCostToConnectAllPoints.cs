namespace LeetCodeSolutions
{
    public class MinCostToConnectAllPoints
    {
        public int MinCostConnectPoints(int[][] points)
        {
            List<Edge> edges = new List<Edge>();
            for (int i = 0; i < points.Length; i++)
            {
                for (int j = i + 1; j < points.Length; j++)
                {
                    Edge edge = new Edge(points[i], points[j], i, j);
                    edges.Add(edge);
                }
            }

            edges.Sort((a, b) => a.distance.CompareTo(b.distance));
            UnionFind unf = new UnionFind(points.Length);
            int res = 0;
            foreach (Edge edge in edges)
            {
                if (unf.Union(edge.node1Index, edge.node2Index))
                {
                    res += edge.distance;
                }
            }

            return res;
        }
    }

    public class UnionFind
    {
        private int[] root;
        private int[] rank;

        public UnionFind(int size)
        {
            this.root = new int[size];
            this.rank = new int[size];

            for (int i = 0; i < size; i++)
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

    public class Edge
    {
        public int[] node1;
        public int[] node2;
        public int node1Index;
        public int node2Index;
        public int distance;

        public Edge(int[] node1, int[] node2, int node1Index, int node2Index)
        {
            this.node1 = node1;
            this.node2 = node2;
            this.node1Index = node1Index;
            this.node2Index = node2Index;
            this.distance = Math.Abs(node1[0] - node2[0]) + Math.Abs(node1[1] - node2[1]);
        }
    }
}
