package me.algo.programmers.kakao2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://javaplant.tistory.com/14
public class K3_autocomplete {
    public static void main(String[] args) {
        String[] words = {"go", "gone", "guild"};

        K3_autocomplete k3Autocomplete = new K3_autocomplete();
        System.out.println(k3Autocomplete.solution(words));
    }

    public int solution(String[] words) {
        Trie trie = new Trie();

        for (String str : words) {
            trie.insert(str);
        }

        int count = 0;
        for (String str : words) {
            for (int i = 1; i <= str.length(); i++) {
                count++;
                String word = str.substring(0, i);
                if (trie.findLeafs(word).size() == 1) {
                    break;
                }
            }
        }

        return count;
    }

    static class TrieNode {
        private boolean isLeaf;
        private final HashMap<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
            isLeaf = false;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }

        public TrieNode putChild(char c) {
            TrieNode temp = new TrieNode();
            getChildren().put(c, temp);
            return temp;
        }

        public TrieNode getChild(char c) {
            return getChildren().get(c);
        }

        public ArrayList<TrieNode> getAllLeaf() {
            ArrayList<TrieNode> retList = new ArrayList<>();
            for (TrieNode child : getChildren().values()) {
                if (child.isLeaf()) {
                    retList.add(child);
                }
                retList.addAll(child.getAllLeaf());
            }
            return retList;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.getChild(c) != null) {
                    current = current.getChild(c);
                } else {
                    current = current.putChild(c);
                }
            }
            current.setLeaf(true);
        }

        public ArrayList<TrieNode> findLeafs(String word) {
            ArrayList<TrieNode> retList = new ArrayList<>();
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.getChild(c) != null) {
                    current = current.getChild(c);
                } else {
                    retList.clear();
                    return retList;
                }
            }

            if (current.isLeaf()) {
                retList.add(current);
            }

            retList.addAll(current.getAllLeaf());
            return retList;
        }
    }
}
