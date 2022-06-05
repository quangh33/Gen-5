package HomeWorkLesson13_15;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            graph.computeIfAbsent(u, __ -> new ArrayList<>()).add(new Pair(v, w));
        }
        Set<Integer> ketSet = graph.keySet();
        for (int key:ketSet){
            List<Pair> pairs = graph.get(key);
            System.out.println("key = " + key);
            for (Pair p : pairs){
                System.out.println("node = " + p.node + " price = " + p.cost);
            }
        }
        // Dijkstra
        int[] costToNode = new int[n];
        int[] numStopsToNode = new int[n];
        Arrays.fill(costToNode, Integer.MAX_VALUE);
        Arrays.fill(numStopsToNode, Integer.MAX_VALUE);
        costToNode[src] = 0;
        numStopsToNode[src] = 0;
        PriorityQueue<Triplet> minHeap = new PriorityQueue<Triplet>(new TripletComparator());
        minHeap.offer(new Triplet(src, 0, 0));
        while (!minHeap.isEmpty()) {
            Triplet currentState = minHeap.poll();
            int currentNode = currentState.node;
            int currentCost = currentState.costFromRoot;
            int currentStops = currentState.numStopsFromRoot;
            if (currentNode == dst) return currentCost;
            if (currentStops == k + 1) continue;
            if(graph.get(currentNode)!= null)
            for (Pair adjNode : graph.get(currentNode)) {
                int nextNode = adjNode.node;
                int nextCost = adjNode.cost + currentCost;
                int nextStopsFromSrc = currentStops + 1;
                if (costToNode[nextNode] > nextCost || numStopsToNode[nextNode] > nextStopsFromSrc)
                    minHeap.offer(new Triplet(nextNode, nextCost, nextStopsFromSrc));
                if (costToNode[nextNode] > nextCost) {
                    costToNode[nextNode] = nextCost;
                    numStopsToNode[nextNode] = nextStopsFromSrc;
                }
            }
        }
        return -1;
    }

    static class Triplet {
        int node;
        int costFromRoot;
        int numStopsFromRoot;

        public Triplet(int node, int costFromRoot, int numStopsFromRoot) {
            this.node = node;
            this.costFromRoot = costFromRoot;
            this.numStopsFromRoot = numStopsFromRoot;
        }
    }

    static class TripletComparator implements Comparator<Triplet> {

        @Override
        public int compare(Triplet t1, Triplet t2) {
            return t1.costFromRoot - t2.costFromRoot;
        }
    }

    static class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] flights ={{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
        int src = 2, dst = 1 , k = 1;
        int a = findCheapestPrice(n,flights,src,dst,k);
    }

}
