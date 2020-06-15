package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int K = 1;
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        System.out.println(cheapestFlightsWithinKStops.findCheapestPrice(n, flights, src, dst, K));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        //creating adjacency list for source cities.
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            //source city: [destination city, source to destination cost].
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        //MinHeap: input format: [city, distance, cost], it compares based on cost.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.add(new int[]{src, 0, 0});
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int city = cur[0], distance = cur[1], cost = cur[2];
            if (city == dst) {
                return cost;
            }
            if (distance <= K) {
                //add adjacent nodes.
                for (int[] adjNode : graph.get(city)) {
                    minHeap.add(new int[]{adjNode[0], distance + 1, cost + adjNode[1]});
                }
            }
        }
        return -1;
    }
}
