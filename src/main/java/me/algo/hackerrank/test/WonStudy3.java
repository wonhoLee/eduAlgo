package me.algo.hackerrank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WonStudy3 {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 4};
//        int d = 7;
//        int[] arr = {4,6,12,8};
//        int d = 14;
        int[] arr = {1,2,3,4};
        int d = 5;

        System.out.println(Arrays.toString(solution(arr, d)));
    }

    public static int[] solution(int[] arr, int d) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();

        int idx = 0;
        for (int i = 1; i <= d; i++) {
            if (i == arr[idx]) {
                if (idx < arr.length - 1) idx++;
            } else {
                list.add(i);
            }
        }

        List<Integer> ret = new ArrayList<>();
        int sum = 0;
        for (Integer i : list) {
            sum += i;
            if (sum > d) {
                break;
            } else if (sum >= d) {
                ret.add(i);
                break;
            }
            ret.add(i);
        }

        int[] retArr = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            retArr[i] = ret.get(i);
        }

        return retArr;
    }
}
