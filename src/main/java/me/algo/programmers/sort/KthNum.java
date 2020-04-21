package me.algo.programmers.sort;

import java.util.*;

public class KthNum {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        KthNum kthNum = new KthNum();
        System.out.println(Arrays.toString(kthNum.solution(array, commands)));
    }

//    public int[] solution(int[] array, int[][] commands) {
//        int[] answer = new int[commands.length];
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//
//        for (int i = 0; i < commands.length; i++) {
//            int start = commands[i][0] - 1;
//            int end = commands[i][1] - 1;
//            int k = commands[i][2];
//            pq.clear();
//            for (int j = start; j <= end; j++) {
//                if(pq.size() < k){
//                    pq.offer(array[j]);
//                }else if(pq.peek() > array[j]){
//                    pq.poll();
//                    pq.offer(array[j]);
//                }
//            }
//            answer[i] = pq.peek();
//        }
//
//        return answer;
//    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
