package Homework.Nam_Nguyen.Lesson16;

public class LeetCode_256_PaintHouse {
    
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] f = new int[n][3];
        f[0][0] = costs[0][0];
        f[0][1] = costs[0][1];
        f[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.min(f[i-1][1], f[i-1][2]) + costs[i][0];
            f[i][1] = Math.min(f[i-1][0], f[i-1][2]) + costs[i][1];
            f[i][2] = Math.min(f[i-1][0], f[i-1][1]) + costs[i][2];
        }
        return minOfArray(f[n-1]);
    }

    private int minOfArray(int[] costs) {
        return Math.min(Math.min(costs[0], costs[1]), costs[2]);
    }

    public static void main(String[] args) {
        LeetCode_256_PaintHouse prob = new LeetCode_256_PaintHouse();
        int[][] costs = {
            {17,2,17},
            {16,16,5},
            {14,3,19}
        };
        System.out.println("res: "+prob.minCost(costs));
    }
}
