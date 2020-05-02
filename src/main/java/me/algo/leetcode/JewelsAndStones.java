package me.algo.leetcode;

public class JewelsAndStones {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String J, String S) {
        int answer = 0;
        for (Character j : J.toCharArray()) {
            for (Character s : S.toCharArray()) {
                if (j == s) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
