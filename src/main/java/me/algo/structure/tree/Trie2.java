package me.algo.structure.tree;

import java.util.ArrayList;
import java.util.HashMap;

//https://javaplant.tistory.com/14
public class Trie2 {
    static class TrieNode {
        private char data;
        private boolean isLeaf;
        private final HashMap<Character, TrieNode> children;

        public TrieNode(char c) {
            this.data = c;
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
            TrieNode temp = new TrieNode(c);
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
            root = new TrieNode(' ');
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
