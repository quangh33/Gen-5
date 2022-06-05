package HomeWorkLesson13_15;

import java.util.PriorityQueue;

public class OptimizeWaterDistributionInAVillage {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int result = 0;
        PriorityQueue<Triplet> minHeap = new PriorityQueue<Triplet>((a, b) -> a.cost - b.cost);
        for (int i = 1; i <= n; i++) {
            minHeap.add(new Triplet(0, i, wells[i - 1]));
        }
        for (int[] pipe : pipes) {
            minHeap.add(new Triplet(pipe[0], pipe[1], pipe[2]));
        }
        int count = n + 1;
        DisjointSetUpdateSize disjointSet = new DisjointSetUpdateSize(n + 1);
        while (count > 1) {
            Triplet currentTriplet = minHeap.poll();
            if (disjointSet.union(currentTriplet.from, currentTriplet.to)) {
                count--;
                result += currentTriplet.cost;
            }
        }
        return result;
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
}
