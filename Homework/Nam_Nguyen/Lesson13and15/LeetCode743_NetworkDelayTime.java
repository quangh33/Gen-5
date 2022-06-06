package Homework.Nam_Nguyen.Lesson13and15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class LeetCode_473_NetworkDelayTime {

    public class Pair {
        int targetNode;
        int time;

        public Pair(int targetNode, int time) {
            this.targetNode = targetNode;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> neighborsList = new HashMap<>();
        for (int[] time : times) {
            neighborsList.computeIfAbsent(time[0], item -> new ArrayList<>()).add(new Pair(time[1], time[2]));
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> {
            return p1.time - p2.time;
        });

        Map<Integer, Integer> distances = new HashMap<>();
        int max = 0;
        minHeap.add(new Pair(k, 0));
        while(!minHeap.isEmpty()) {
            Pair curr = minHeap.poll();
            if(distances.containsKey(curr.targetNode)) continue;
            distances.put(curr.targetNode, curr.time);
            if(curr.time > max) {
                max = curr.time;
            }
            if(neighborsList.containsKey(curr.targetNode)) {
                for (Pair neighbor : neighborsList.get(curr.targetNode)) {
                    minHeap.add(new Pair(neighbor.targetNode, neighbor.time + curr.time));
                }
            }
        }
        if(distances.size() < n)
            return -1;
        return max;
    }

    public static void main(String[] args) {
        LeetCode_473_NetworkDelayTime prob = new LeetCode_473_NetworkDelayTime();
        int[][] times = {{1,2,1}};
        int n = 2, k = 2;
        System.out.println("res: "+prob.networkDelayTime(times, n, k));
    }
}