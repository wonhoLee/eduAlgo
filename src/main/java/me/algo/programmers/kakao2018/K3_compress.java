package me.algo.programmers.kakao2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class K3_compress {
    public static void main(String[] args) {
//        String msg = "KAKAO";
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        K3_compress k3_compress = new K3_compress();
        System.out.println(Arrays.toString(k3_compress.solution(msg)));
    }

    public int[] solution(String msg) {
        HashMap<String, Integer> maps = new HashMap<>();
        maps.put("A", 1);
        maps.put("B", 2);
        maps.put("C", 3);
        maps.put("D", 4);
        maps.put("E", 5);
        maps.put("F", 6);
        maps.put("G", 7);
        maps.put("H", 8);
        maps.put("I", 9);
        maps.put("J", 10);
        maps.put("K", 11);
        maps.put("L", 12);
        maps.put("M", 13);
        maps.put("N", 14);
        maps.put("O", 15);
        maps.put("P", 16);
        maps.put("Q", 17);
        maps.put("R", 18);
        maps.put("S", 19);
        maps.put("T", 20);
        maps.put("U", 21);
        maps.put("V", 22);
        maps.put("W", 23);
        maps.put("X", 24);
        maps.put("Y", 25);
        maps.put("Z", 26);

        String[] msgArr = msg.split("");
        /*
        for
        현재 -> maps 있으면 현재 저장하고 다음
        다음 -> 현재+다음 maps 있으면 저장하고 다음
                             없으면 현재 로 maps.val 저장 현재+다음 maps 저장, 다음 저장
        마지막일경우 maps.val 저장
         */
        List<Integer> answerList = new ArrayList<>();
        String saveStr = "";
        for (int i = 0; i < msgArr.length; i++) {
            String currStr = msgArr[i];
            if (maps.containsKey(saveStr + currStr)) {
                saveStr += currStr;
            } else {
                answerList.add(maps.get(saveStr));
                maps.put(saveStr + currStr, maps.size() + 1);
                saveStr = currStr;
            }
            if (i == msgArr.length - 1) {
                answerList.add(maps.get(saveStr));
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

}
