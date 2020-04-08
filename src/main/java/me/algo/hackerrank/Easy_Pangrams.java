package me.algo.hackerrank;

import java.util.Arrays;

public class Easy_Pangrams {
    public static void main(String[] args) {
//        String s = "We promptly judged antique ivory buckles for the next prize";
        String s = "We promptly judged antique ivory buckles for the prize";
        System.out.println(solution(s));

    }

    public static String solution(String s){
        String[] sourceArr = "abcdefghijklmnopqrstuvwxyz".split("");
        Arrays.sort(sourceArr);
        String[] targetArr = s.toLowerCase().split("");
        Arrays.sort(targetArr);

        int sourceIdx = 0;
        for (int i = 0; i < targetArr.length - 1; i++) {
            if(sourceArr[sourceIdx].equals(targetArr[i])){
                if(sourceIdx == sourceArr.length -1) break;
                sourceIdx++;
            }
        }

        if(sourceIdx == sourceArr.length-1){
            return "pangram";
        }else{
            return "not pangram";
        }

    }
}
