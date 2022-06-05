package HomeWorkLesson13_15;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoint {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Triplet> minHeap = new PriorityQueue<Triplet>((a, b) -> a.cost - b.cost);
        int n = points.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = getCost(points[i], points[j]);
                minHeap.add(new Triplet(i, j, cost));
            }
        }
        int count = points.length;
        DisjointSet disjointSet = new DisjointSet(n);
        while (count > 1) {
            Triplet currentTriplet = minHeap.poll();
            if (disjointSet.union(currentTriplet.from, currentTriplet.to)) {
                count--;
                result += currentTriplet.cost;
            }
        }
        return result;
    }

    public int getCost(int[] from, int[] to) {
        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }

    class Triplet {
        int from;
        int to;
        int cost;

        public Triplet(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {

    }
}
