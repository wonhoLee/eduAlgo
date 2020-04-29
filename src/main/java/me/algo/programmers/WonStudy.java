package me.algo.programmers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Stack;

public class WonStudy {
    public static void main(String[] args) {
//        int[] heights = {6, 9, 5, 7, 4};
//
//        WonStudy wonStudy = new WonStudy();
//        System.out.println(Arrays.toString(wonStudy.solution(heights)));

//        LocalDateTime localDateTime = LocalDateTime.parse("2020-04-29 11:24:00.000", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
//        LocalDateTime localDateTime1 = LocalDateTime.parse("2020-04-29 11:23:00.000", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
//        LocalDateTime localDateTime2 = LocalDateTime.parse("2020-04-29 11:25:00.000", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
//        System.out.println(localDateTime.isAfter(localDateTime1));
//        System.out.println(localDateTime.isBefore(localDateTime2));
////        (ChronoUnit.NANOS.between(start, arr2[0]) >= 0 && ChronoUnit.NANOS.between(start.plusSeconds(1), arr2[1]) <= 0)
//        System.out.println(ChronoUnit.NANOS.between(localDateTime, localDateTime));
        LocalDateTime localDateTime = LocalDateTime.parse("2020-04-29 09:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(localDateTime);
    }

    /*
    stack
    s 넣고
    while stack
        idx = stack.size
        for array reverse
        if(array[idx] > s.pop){
        result[idx] = fori;
        break;
        )
     */
    public int[] solution(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int[] answer = new int[heights.length];
        Arrays.fill(answer, 0);

        for (int val : heights) {
            s.push(val);
        }

        while (!s.empty()) {
            int idx = s.size() - 1;
            int cur = s.pop();
            for (int i = idx - 1; i >= 0; i--) {
                if (heights[i] > cur) {
                    answer[idx] = i + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
