package Homework.Nam_Nguyen.Lesson13and15;

import java.util.PriorityQueue;

public class LeetCode_1168_OptimizeWaterDistributionInVillage {

    public class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 1; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x == parent[x])
                return x;
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
                size[py] += size[px];
                return true;
            }
            return false;
        }
    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int minCost = 0;
        UnionFind unionFind = new UnionFind(n+1);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);
        for (int[] pipe : pipes) {
            minHeap.add(pipe);
        }

        for (int i = 0; i < wells.length; i++) {
            minHeap.add(new int[]{0, i+1, wells[i]});
        }

        while(!minHeap.isEmpty()) {
            int[] connection = minHeap.poll();
            boolean isConnected = unionFind.union(connection[0], connection[1]);
            if(isConnected) {
                minCost+=connection[2];
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] wells = {1,2,2};
        int[][] pipes = {{1,2,1},{2,3,1}};
        LeetCode_1168_OptimizeWaterDistributionInVillage prob = new LeetCode_1168_OptimizeWaterDistributionInVillage();
        prob.minCostToSupplyWater(n, wells, pipes);
    }
}
