package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";

        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        System.out.println(findAllAnagramsInAString.findAnagrams(s, p));
    }

//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> answer = new ArrayList<>();
//
//        String[] pArr = p.split("");
//        Arrays.sort(pArr);
//        String pStr = String.join("", pArr);
//
//        for (int i = 0; i <= s.length() - p.length(); i++) {
//            String[] tempArr = s.substring(i, i + p.length()).split("");
//            Arrays.sort(tempArr);
//            if (pStr.equals(String.join("", tempArr))) {
//                answer.add(i);
//            }
//        }
//
//        return answer;
//    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0) return result;

        int[] char_counts = new int[26];
        for (char c : p.toCharArray()) {
            char_counts[c - 'a']++;
        }
        System.out.println(Arrays.toString(char_counts));

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {
            if (char_counts[s.charAt(right++) - 'a']-- >= 1) count--;
            if (count == 0) result.add(left);
            if (right - left == p.length() && char_counts[s.charAt(left++) - 'a']++ >= 0) count++;
        }

        return result;
    }

    public List<Integer> wonStudy(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pArr = new int[26];
        for (char c : p.toCharArray()) {
            pArr[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (pArr[s.charAt(right++) - 'a']-- >= 1) count--;
            if (count == 0) result.add(left);
            if (right - left == p.length() && pArr[s.charAt(left++) - 'a']++ >= 0) count++;
        }

        return result;
    }
}
