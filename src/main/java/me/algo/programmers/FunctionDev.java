package me.algo.programmers;

import java.util.*;

public class FunctionDev {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        FunctionDev functionDev = new FunctionDev();
        System.out.println(Arrays.toString(functionDev.solution(progresses, speeds)));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int todo = 100 - progresses[i];
            int manDay = 0;
            if (todo % speeds[i] > 0) {
                manDay = todo / speeds[i] + 1;
            } else {
                manDay = todo / speeds[i];
            }
            q.offer(manDay);
        }

        List<Integer> list = new ArrayList<>();
        int day = q.poll();
        int nCnt = 1;
        do {
            int value = q.poll();
            if (day < value) {
                list.add(nCnt);
                nCnt = 1;
                day = value;
            } else {
                nCnt++;
            }
        } while (!q.isEmpty());
        list.add(nCnt);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
