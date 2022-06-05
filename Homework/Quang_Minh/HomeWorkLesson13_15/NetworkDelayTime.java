package HomeWorkLesson13_15;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            graph.computeIfAbsent(u, __ -> new ArrayList<>()).add(new Pair(v, w));
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new PairComparator());
        int[] minTimes = new int[n + 1];
        Arrays.fill(minTimes, Integer.MAX_VALUE);
        minTimes[k] = 0;
        minHeap.add(new Pair(k, 0));
        while (!minHeap.isEmpty()) {
            Pair currentPair = minHeap.poll();

            int curNode = currentPair.node;
            int curTime = currentPair.currentTime;

            if (minTimes[curNode] >= curTime) {
                if (graph.containsKey(curNode)) {
                    for (Pair adjPair : graph.get(curNode)) {
                        int nextNode = adjPair.node;
                        int nextTime = adjPair.currentTime;

                        if (minTimes[nextNode] > curTime + nextTime) {
                            minTimes[nextNode] = curTime + nextTime;
                            minHeap.offer(new Pair(nextNode, minTimes[nextNode]));
                        }
                    }
                }
            }
        }
        int time = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            time = Math.max(time, minTimes[i]);
        }
        return time == Integer.MAX_VALUE ? -1 : time;
    }

    class Pair {
        int node;
        int currentTime;

        public Pair(int node, int currentTime) {
            this.node = node;
            this.currentTime = currentTime;
        }
    }

    class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair pair1, Pair pair2) {
            if (pair1.currentTime > pair1.currentTime)
                return 1;
            else if (pair1.currentTime < pair1.currentTime)
                return -1;
            return 0;
        }
    }

}
