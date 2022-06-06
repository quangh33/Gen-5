package Homework.Nam_Nguyen.Lesson13and15;

import java.util.Arrays;

public class LeetCode_952_LargestComponentSizeByCommonFactor {

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
    
        public int getMaxSize() {
            int max = 0;
            for (int s : size) {
                max = Math.max(max, s);
            }
            return max;
        }
    
        public int[] getSizes() {
            return size;
        }
    }

    public int largestComponentSize(int[] nums) {

        int max = Arrays.stream(nums).max().getAsInt();
        UnionFind unionFind = new UnionFind(max + 1);

        for (int num : nums) {
            int root = unionFind.find(num);
            unionFind.getSizes()[root]++;
            for(int factor = 1; factor <= Math.sqrt(num); factor++){
                if(num%factor==0){
                    int anotherFactor = num / factor;
                    int anotherFactorRoot = unionFind.find(anotherFactor);
                    
                    if(factor != 1){
                        unionFind.union(root, factor);
                    }
                    unionFind.union(root, anotherFactorRoot);
                }
            }
        }
        return unionFind.getMaxSize();
    }
    
    public static void main(String[] args) {
        LeetCode_952_LargestComponentSizeByCommonFactor prob = new LeetCode_952_LargestComponentSizeByCommonFactor();
        int[] nums = {4,6,15,35};
        prob.largestComponentSize(nums);
    }
}
