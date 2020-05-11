package me.algo.leetcode;

import java.util.HashMap;

public class FindTheTownJudge {
    public static void main(String[] args) {
//        int N = 2; int[][] trust = {{1, 2}};
//        int N = 3; int[][] trust = {{1, 3}, {2, 3}};
//        int N = 3; int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
//        int N = 3; int[][] trust = {{1, 2}, {2, 3}};
        int N = 4; int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        FindTheTownJudge findTheTownJudge = new FindTheTownJudge();
        System.out.println(findTheTownJudge.findJudge(N, trust));
    }

    public int findJudge(int N, int[][] trust) {
        if(N == 1) return 1;
        int answer = -1;
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for (int[] cur : trust) {
            hashMap1.put(cur[0], 0);
            hashMap2.put(cur[1], hashMap2.getOrDefault(cur[1], 0) + 1);
        }

        for (Integer key : hashMap2.keySet()) {
            if (hashMap2.get(key) == N-1 && !hashMap1.containsKey(key)) {
                answer = key;
            }
        }

        return answer;
    }
}
