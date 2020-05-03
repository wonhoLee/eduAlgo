package me.algo.leetcode;

import java.util.Arrays;

public class RansomNote {
    public static void main(String[] args) {
//        String ransomNote = "a"; String magazine = "b";
        String ransomNote = "aa"; String magazine = "ab";
//        String ransomNote = "aa"; String magazine = "aab";
//        String ransomNote = "fffbfg"; String magazine = "effjfggbffjdgbjjhhdegh";
        RansomNote r = new RansomNote();
        System.out.println(r.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        boolean answer = true;
        boolean[] visited = new boolean[magazine.length()];
        Arrays.fill(visited, false);

        for (Character r:ransomNote.toCharArray()) {
            boolean temp = false;
            for (int i = 0; i < magazine.length(); i++) {
                if(visited[i]) continue;
                if(r == magazine.charAt(i)) {
                    visited[i] = true;
                    temp = true;
                    break;
                }
            }
            if(!temp) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
