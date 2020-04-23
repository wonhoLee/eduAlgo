package me.algo.programmers.sort;

import java.util.Arrays;

public class LargestNum {
    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2};
        int[] numbers = {3, 30, 34, 5, 9};
        LargestNum largestNum = new LargestNum();
        System.out.println(largestNum.solution(numbers));
    }

    public String solution(int[] numbers) {
        String answer = "";

        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (String str : strings) {
            answer += str;
        }

        if ("0".equals(answer.substring(0, 1))) return "0";

        return answer;
    }
}
