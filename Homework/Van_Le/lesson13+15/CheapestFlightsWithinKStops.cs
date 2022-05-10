namespace LeetCodeSolutions
{
    public class CheapestFlightsWithinKStops
    {
        public int FindCheapestPrice(int n, int[][] flights, int src, int dst, int k)
        {
            var adjList = new Dictionary<int, List<Tuple<int, int>>>();
            BuildAdjacencyList(n, flights, adjList);
            //<dstCity, Cost, K>
            PriorityQueue<Tuple<int, int, int>, int> pq =
                new PriorityQueue<Tuple<int, int, int>, int>();

            int[] totCities = new int[n];
            for (int i = 0; i < n; i++)
            {
                totCities[i] = Int32.MaxValue;
            }

            pq.Enqueue(new Tuple<int, int, int>(src, 0, 0), 0);

            while (pq.Count > 0)
            {

                var temp = pq.Dequeue();
                var u = temp.Item1;
                var currC = temp.Item2;
                var currK = temp.Item3;

                if (u == dst) return currC;
                if (currK > k || totCities[u] < currK) continue;

                totCities[u] = currK;

                Console.WriteLine(temp);
                foreach (var neighbor in adjList[u])
                {
                    var v = neighbor.Item1;
                    var c = neighbor.Item2;

                    pq.Enqueue(new Tuple<int, int, int>(v, c + currC, currK + 1), c + currC);
                }

            }
            return -1;
        }

        private void BuildAdjacencyList(int n, int[][] flights, Dictionary<int, List<Tuple<int, int>>> adjList)
        {
            for (int i = 0; i < n; i++)
            {
                adjList.Add(i, new List<Tuple<int, int>>());
            }

            foreach (var flight in flights)
            {
                var u = flight[0];
                var v = flight[1];
                var c = flight[2];

                adjList[u].Add(new Tuple<int, int>(v, c));
            }

        }
    }
}
