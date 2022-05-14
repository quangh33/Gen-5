package Homework.Nam_Nguyen.Lesson13and15;

import java.util.Arrays;


public class LeetCode_1101_TheEarliestMomentWhenEveryoneBecomeFriends {

    public class UnionFind {
        private int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if(x == parent[x])
                return x;
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if(px != py) {
                parent[px] = py;
                return true;
            }
            return false;
        }

        public int size() {
            int res = 0;
            for (int i = 0; i < parent.length; i++) {
                if(i == parent[i]) res++;
            }
            return res;
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (log1, log2) -> log1[0] - log2[0]);
        UnionFind unionFind = new UnionFind(n);
        int timestamp = 0;

        for (int[] log : logs) {
            int time = log[0];
            int x = log[1];
            int y = log[2];
            boolean unionSuccess = unionFind.union(x, y);
            if(unionSuccess) {
                timestamp = time;
            }
        }

        if(unionFind.size() == 1)   return timestamp;
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_1101_TheEarliestMomentWhenEveryoneBecomeFriends prob = new LeetCode_1101_TheEarliestMomentWhenEveryoneBecomeFriends();
        int[][] logs = {{9,3,0},{0,2,1},{8,0,1},{1,3,2},{2,2,0},{3,3,1}};
        int n = 4;
        System.out.println("Res: "+prob.earliestAcq(logs, n));
        
    }
    
}
