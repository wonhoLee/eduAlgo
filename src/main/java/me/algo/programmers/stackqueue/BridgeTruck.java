package me.algo.programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
//        int bridge_length = 100; int weight = 100; int[] truck_weights = {10};
//        int bridge_length = 100; int weight = 100; int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        BridgeTruck bridgeTruck = new BridgeTruck();
        System.out.println(bridgeTruck.solution(bridge_length, weight, truck_weights));
    }

    /*

     */
    static class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> wait = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        int time = 0;
        int curBridgeWeight = 0;

        for (int val : truck_weights) {
            wait.offer(new Truck(val, 0));
        }

        while (!wait.isEmpty() || !bridge.isEmpty()) {
            time++;
            if (!bridge.isEmpty()) {
                Truck truck = bridge.peek();
                if (time - truck.time == bridge_length) {
                    curBridgeWeight -= truck.weight;
                    bridge.poll();
                }
            }
            if (!wait.isEmpty()) {
                Truck truck = wait.peek();
                if (curBridgeWeight + truck.weight <= weight) {
                    curBridgeWeight += truck.weight;
                    bridge.offer(new Truck(truck.weight, time));
                    wait.poll();
                }
            }
        }

        return time;
    }
}
