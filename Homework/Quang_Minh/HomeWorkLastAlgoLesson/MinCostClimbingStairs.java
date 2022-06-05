package HomeWorkLastAlgoLesson;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0)
            return 0;
        if (cost.length == 1)
            return cost[0];
        int length = cost.length;
        int[] state = new int[length + 1];

        state[0] = 0;
        state[1] = cost[0];
        for (int i = 2; i <= length; i++) {
            state[i] = cost[i - 1] + Math.min(state[i - 1], state[i - 2]);
        }

        return Math.min(state[length], state[length - 1]);
    }
}
