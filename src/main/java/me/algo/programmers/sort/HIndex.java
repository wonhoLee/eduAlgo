package me.algo.programmers.sort;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
//        int[] citations = {3, 0, 6, 1, 5};
        int[] citations = {5, 5, 5, 5};
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.solution(citations));
    }

//    public int solution(int[] citations) {
//        int answer = 0;
//        for (int i = 0; i <= citations.length; i++) {
//            int cnt = 0;
//            for (int j = 0; j < citations.length; j++) {
//                if(citations[j] >= i) cnt++;
//            }
//            if(cnt >= i && citations.length - cnt <= i) answer = Math.max(answer, i);
//        }
//
//        return answer;
//    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = citations.length - 1; i >= 0; i--) {
            int min = Math.min(citations[i], citations.length - i);
            if (answer < min) answer = min;
        }
        return answer;
    }
}
