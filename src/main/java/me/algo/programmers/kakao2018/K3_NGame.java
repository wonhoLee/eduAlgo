package me.algo.programmers.kakao2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K3_NGame {
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        K3_NGame k3_nGame = new K3_NGame();
        System.out.println(k3_nGame.solution(n, t, m, p));
    }

    /*
    0부터 숫자 올리기
    n진수 변환

     */
    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < t * m; i++) {
            int value = i;
            while (value != 0) {
                if ((value % n) < 10) {
                    answer.insert(0, (value % n));
                    value /= n;
                } else {
                    int temp = (char) ((value % n) + 55);
                    answer.insert(0, temp);
                }
            }

            if (answer.toString().equals("")) {
                answer.append("0");
            }
            Collections.addAll(list, answer.toString().split(""));
            answer.delete(0, answer.length());
        }

        for (int i = p - 1; i < list.size(); i += (p + 1)) {
            result.append(list.get(i));
            if (result.length() == t) break;
        }

        return result.toString();
    }
}
