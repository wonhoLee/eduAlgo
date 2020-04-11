package me.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;

        Printer printer = new Printer();
        System.out.println(printer.solution(priorities, location));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int pri : priorities) {
            q.add(pri);
        }
        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == priorities[size - answer]) {
                answer++;
                location--;
                if (location < 0) break;
            } else {
                q.add(cur);
                location--;
                if (location < 0) location = q.size() - 1;
            }
        }

        return answer;
    }
}
