package me.algo.leetcode;

import java.util.HashMap;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));

    }

    public static int firstUniqChar(String s) {
        int answer = -1;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
