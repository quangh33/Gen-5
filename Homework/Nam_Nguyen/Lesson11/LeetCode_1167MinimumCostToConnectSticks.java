package Homework.Nam_Nguyen.Lesson11;

import java.util.PriorityQueue;

public class LeetCode_1167MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (Integer stick : sticks) {
            queue.add(stick);
        }

        while(queue.size() >= 2) {
            int first = queue.poll();
            int second = queue.poll();
            int sum = first + second;
            cost+=sum;
        }
        
        return cost;
    }

    public static void main(String[] args) {
        int[] sticks = {3354,4316,3259,4904,4598,474,3166,6322,8080,9009};
        LeetCode_1167MinimumCostToConnectSticks prob = new LeetCode_1167MinimumCostToConnectSticks();
        System.out.println(prob.connectSticks(sticks));
    }
    
}
