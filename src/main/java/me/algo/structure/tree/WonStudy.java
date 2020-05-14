package me.algo.structure.tree;

public class WonStudy {
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WonStudy() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int level;
        int length = word.length();
        int index;
        TrieNode node = root;
        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int level;
        int length = word.length();
        int index;
        TrieNode node = root;
        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int level;
        int length = prefix.length();
        int index;
        TrieNode node = root;
        for (level = 0; level < length; level++) {
            index = prefix.charAt(level) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null;
    }

    public static void main(String[] args) {
        WonStudy wonStudy = new WonStudy();
        wonStudy.insert("apple");
        wonStudy.search("apple");
    }
}
