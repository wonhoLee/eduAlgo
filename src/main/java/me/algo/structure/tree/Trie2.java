package me.algo.structure.tree;

import java.util.ArrayList;
import java.util.HashMap;

//https://javaplant.tistory.com/14
public class Trie2 {
    static class TrieNode {
        private char data;
        private boolean isLeaf;
        private HashMap<Character, TrieNode> children;

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

    
}
