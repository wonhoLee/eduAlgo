package me.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(stones));
    }

//    public int lastStoneWeight(int[] stones) {
//        List<Integer> list = Arrays.stream(stones)
//                .boxed()
//                .collect(Collectors.toList());
//
//        while(list.size() > 1){
//            Collections.sort(list, Collections.reverseOrder());
//
//            if(list.get(0) == list.get(1)){
//                list.remove(0);
//                list.remove(0);
//            }else{
//                list.set(0, list.get(0) - list.get(1));
//                list.remove(1);
//            }
//        }
//
//        return (list.isEmpty()) ? 0 : list.get(0);
//    }



    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone:stones) {
            pq.offer(stone);
        }

        while(pq.size() != 1){
            int y = pq.poll();
            int x = pq.poll();
            if(x != y){
                pq.offer(y - x);
            }
        }

        return (pq.isEmpty()) ? 0 : pq.poll();
    }
}
