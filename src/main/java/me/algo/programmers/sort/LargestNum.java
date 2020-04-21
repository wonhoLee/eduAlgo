package me.algo.programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNum {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        LargestNum largestNum = new LargestNum();
        System.out.println(largestNum.solution(numbers));
    }

    public String solution(int[] numbers) {
        String answer = "";

        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
//        Arrays.sort(strings);

        System.out.println(Arrays.toString(numbers));

        return answer;
    }
}
