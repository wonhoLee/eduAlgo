package me.algo.programmers.kakao2018;

import java.util.Arrays;

//https://javaplant.tistory.com/14
public class K3_autocomplete {
    public static void main(String[] args) {
        String[] words = {"go", "gone", "guild"};

        K3_autocomplete k3Autocomplete = new K3_autocomplete();
        System.out.println(k3Autocomplete.solution(words));
    }

    /*
    한번입력 -> 저장
    다음입력시 자동완성
    앞부분이 동일한개 >1이면 다른문자 나올때까지 입력

     */
    public int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }



        return answer;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            Arrays.fill(children, null);
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String key) {
            TrieNode node = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        public boolean search(String key) {
            TrieNode node = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (node.children[index] == null) return false;
                node = node.children[index];
            }
            return (node != null && node.isEndOfWord);
        }
    }
}
