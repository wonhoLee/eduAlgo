package me.algo.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temptest {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5,1,2,3,4,5};
//        int[] answers = {};

        Temptest temptest = new Temptest();
        System.out.println(Arrays.toString(temptest.solution(answers)));
    }

    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] ret = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % 5]) ret[0]++;
            if (answers[i] == student2[i % 8]) ret[1]++;
            if (answers[i] == student3[i % 10]) ret[2]++;
        }

        int maxScore = Math.max(ret[0], ret[1]);
        maxScore = Math.max(maxScore, ret[2]);

        List<Integer> list = new ArrayList<>();
        if (ret[0] == maxScore) list.add(1);
        if (ret[1] == maxScore) list.add(2);
        if (ret[2] == maxScore) list.add(3);

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
