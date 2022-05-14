package Homework.Nam_Nguyen.Lesson13and15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode_787_CheapestFlightsWithinKStops {

    public class Neighbor {
        int city;
        int cost;

        public Neighbor(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    public class Flight {
        int dest;
        int cost;
        int stops;

        public Flight(int dest, int cost, int stops) {
            this.dest = dest;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;

        Map<Integer, List<Neighbor>> neighbors = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            neighbors.computeIfAbsent(flights[i][0], item -> new ArrayList<>()).add(new Neighbor(flights[i][1], flights[i][2]));
        }

        PriorityQueue<Flight> minHeap = new PriorityQueue<>((f1, f2) -> f1.cost - f2.cost);
        int[] costs = new int[n];
        int[] stops = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        costs[src] = 0;
        stops[src] = 0;

        minHeap.add(new Flight(src, 0, 0));

        while(!minHeap.isEmpty()) {
            Flight currFlight = minHeap.poll();
            int dest = currFlight.dest;
            int cost = currFlight.cost;
            int stop = currFlight.stops;

            if(dest == dst) {
                return cost;
            }

            if(stop == k) continue;

            if(neighbors.containsKey(dest)) {
                for (Neighbor neighbor : neighbors.get(dest)) {
                    int nextDest = neighbor.city;
                    int newCost = cost + neighbor.cost;
                    int newStops = stop + 1;
                    if(newCost < costs[nextDest] || newStops < stops[nextDest]) {
                        minHeap.add(new Flight(nextDest, newCost, newStops));
                        costs[nextDest] = newCost;
                        stops[nextDest] = newStops;
                    }
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        LeetCode_787_CheapestFlightsWithinKStops prob = new LeetCode_787_CheapestFlightsWithinKStops();
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        System.out.println("res: "+prob.findCheapestPrice(n, flights, src, dst, k));
    }
}
