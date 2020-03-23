package me.algo.programmers.kakao2020;

import java.util.Arrays;
import java.util.HashMap;

//https://programmers.co.kr/learn/courses/30/lessons/60060
public class Q4_lyricsSearch {
    public static void main(String[] args) {
        Q4_lyricsSearch q4_lyricsSearch = new Q4_lyricsSearch();

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(q4_lyricsSearch.solution(words, queries)));
    }

//    public int[] solution(String[] words, String[] queries) {
//        int[] answer = new int[queries.length];
//
//        for (int i = 0; i < queries.length; i++) {
//            answer[i] = findWord(words, queries[i]);
//        }
//
//        return answer;
//    }
//
//    public int findWord(String[] words, String query) {
//        int resultValue = 0;
//        for (String str : words) {
//            if (query.length() == str.length()) {
//                boolean temp = true;
//                for (int i = 0; i < query.length(); i++) {
//                    if (query.charAt(i) != '?' && str.charAt(i) != query.charAt(i)) {
//                        temp = false;
//                        continue;
//                    }
//                }
//                if (temp) resultValue++;
//            }
//        }
//        return resultValue;
//    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie root = new Trie('*');
        for (String word : words) {
            Trie prev = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                Trie curr = new Trie(c);
                prev = prev.putChild(curr, word.length());
            }
        }

        //reverse
        Trie rootReverse = new Trie('*');
        for (String word : words) {
            Trie prev = rootReverse;
            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                Trie curr = new Trie(c);
                prev = prev.putChild(curr, word.length());
            }
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (query.charAt(0) != '?') {
                Trie trav = root;
                for (int j = 0; j < query.length(); j++) {
                    char c = query.charAt(j);
                    if (c == '?') {
                        answer[i] = trav.getNumChildrenWithLen(query.length());
                        break;
                    }
                    trav = trav.getChild(c);
                    if (trav == null) {
                        answer[i] = 0;
                        break;
                    }
                }
            } else {
                Trie trav = rootReverse;
                for (int j = query.length() - 1; j >= 0; j--) {
                    char c = query.charAt(j);
                    if (c == '?') {
                        answer[i] = trav.getNumChildrenWithLen(query.length());
                        break;
                    }
                    trav = trav.getChild(c);
                    if (trav == null) {
                        answer[i] = 0;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}

class Trie {
    char c;
    HashMap<Character, Trie> children;
    HashMap<Integer, Integer> numChildrenWithLen;

    Trie(char c) {
        this.c = c;
        children = new HashMap<Character, Trie>();
        numChildrenWithLen = new HashMap<Integer, Integer>();
    }

    Trie putChild(Trie t, int len) {
        if (!children.containsKey(t.c)) {
            children.put(t.c, t);
        }
        if (numChildrenWithLen.containsKey(len)) {
            numChildrenWithLen.put(len, numChildrenWithLen.get(len) + 1);
        } else {
            numChildrenWithLen.put(len, 1);
        }
        return children.get(t.c);
    }

    Trie getChild(char c) {
        return children.get(c);
    }

    int getNumChildrenWithLen(int len) {
        if (numChildrenWithLen.containsKey(len)) return numChildrenWithLen.get(len);
        return 0;
    }
}