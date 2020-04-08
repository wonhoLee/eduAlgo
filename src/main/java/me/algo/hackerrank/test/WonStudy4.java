package me.algo.hackerrank.test;

import java.util.Arrays;

public class WonStudy4 {
    public static void main(String[] args) {
//        String s = "progxrammerrxproxgrammer";
        String s = "progxrammer";
        System.out.println(solution(s));
    }

    public static int solution(String s){

        return recursion(s, 0, 10);
    }

    public static int recursion(String s, int start, int end){
        if(end - start < 10 || end > s.length()) return 0;

        String[] sourceArr = "programmer".split("");
        String[] targetArr = s.substring(start, end).split("");
        Arrays.sort(sourceArr);
        Arrays.sort(targetArr);

        int sourceIdx = 0;
        for (int i = 0; i < targetArr.length; i++) {
            if(sourceArr[sourceIdx].equals(targetArr[i])) {
                if(sourceIdx == sourceArr.length - 1) break;
                sourceIdx++;
            }
        }

        if(sourceIdx == sourceArr.length - 1){
            return 1 + recursion(s, end, end + 10);
        }else{
            return recursion(s, start, end + 1);
        }
    }

}
