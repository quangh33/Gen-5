namespace LeetCodeSolutions
{
    public class NetworkDelayTime_Dijsktra
    {
        public int NetworkDelayTime(int[][] times, int n, int k)
        {
            var dist = new int[n];
            Fill(dist);

            var wt = new Dictionary<(int u, int v), int>();
            var adjlist = new List<List<int>>(n);
            var mset = new bool[n];
            FillAdjList(n, adjlist, times, wt);

            dist[--k] = 0;

            for (int count = 0; count < n; count++)
            {
                int u = -1;
                if (count == 0) u = k;
                else
                {
                    for (int i = 0; i < n; i++)
                    {
                        if (!mset[i] && (u == -1 || dist[i] < dist[u]))
                            u = i;
                    }
                }
                mset[u] = true;

                for (int i = 0; i < adjlist[u].Count; i++)
                {
                    var v = adjlist[u][i];
                    if (!mset[v])
                    {
                        int thisedge = wt.ContainsKey((u, v)) ? wt[(u, v)] : wt[(v, u)];
                        dist[v] = Math.Min(dist[v], dist[u] + thisedge);
                    }
                }
            }

            int MaxDistance = int.MinValue;
            for (int i = 0; i < n; i++)
            {
                if (dist[i] == int.MaxValue) return -1;
                MaxDistance = Math.Max(MaxDistance, dist[i]);
            }

            return MaxDistance;
        }

        public static void Fill(int[] A)
        {
            for (int i = 0; i < A.Length; i++)
                A[i] = int.MaxValue;
        }

        public static void FillAdjList(int n, List<List<int>> adjlist, int[][] times, Dictionary<(int u, int v), int> wt)
        {
            for (int i = 0; i < n; i++)
            {
                adjlist.Add(new List<int>());
            }

            for (int i = 0; i < times.Length; i++)
            {

                if (!wt.ContainsKey((times[i][0] - 1, times[i][1] - 1)))
                {
                    wt[(times[i][0] - 1, times[i][1] - 1)] = times[i][2];
                    adjlist[times[i][0] - 1].Add(times[i][1] - 1);
                }
            }
        }
    }
}
