package Homework.Nam_Nguyen.Lesson16;

class LeetCode_746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1)  return cost[0];
        if(n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        if(n == 3) {
            return Math.min(cost[0] + cost[2], cost[1]);
        }
        int[] steps = new int[n];
        steps[0] = cost[0];
        steps[1] = cost[1];

        for (int i = 2; i < n; i++) {
            steps[i] = Math.min(steps[i-1], steps[i-2]) + cost[i];
        }

        return Math.min(steps[n-1], steps[n-2]);
    }

    public static void main(String[] args) {
        LeetCode_746_MinCostClimbingStairs prob = new LeetCode_746_MinCostClimbingStairs();
        int[] cost = {10,15,20};
        System.out.println("res: "+prob.minCostClimbingStairs(cost));
    }
}