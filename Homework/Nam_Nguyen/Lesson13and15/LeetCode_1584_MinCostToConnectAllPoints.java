package Homework.Nam_Nguyen.Lesson13and15;

import java.util.PriorityQueue;

public class LeetCode_1584_MinCostToConnectAllPoints {

    public class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
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
                return true;
            }
            return false;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((c1, c2) -> c1[2] - c2[2]);
        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int minDis = Integer.MAX_VALUE;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int distance = Math.abs(x1-x2) + Math.abs(y1-y2);
                if(distance < minDis){
                    minDis = distance;
                    minHeap.add(new int[]{i,j,distance});
                }
            }
        }

        UnionFind unionFind = new UnionFind(points.length);

        while(!minHeap.isEmpty()) {
            int[] connection = minHeap.poll();
            boolean canBeUnioned = unionFind.union(connection[0], connection[1]);
            if(canBeUnioned) {
                cost+=connection[2];
            }
        }

        return cost;
    }
    

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        // int[][] points = {{3,12},{-2,5},{-4,1}};
        LeetCode_1584_MinCostToConnectAllPoints prob = new LeetCode_1584_MinCostToConnectAllPoints();
        System.out.println("res: "+prob.minCostConnectPoints(points));
    }
}
