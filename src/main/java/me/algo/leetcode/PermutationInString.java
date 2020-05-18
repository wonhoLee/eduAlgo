package me.algo.leetcode;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        for (char c : s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = s1.length();
        while (right < s2.length()) {
            if (s1Arr[s2.charAt(right++) - 'a']-- >= 1) count--;
            if (count == 0) return true;
            if (right - left == s1.length() && s1Arr[s2.charAt(left++) - 'a']++ >= 0) count++;
        }

        return false;
    }
}
