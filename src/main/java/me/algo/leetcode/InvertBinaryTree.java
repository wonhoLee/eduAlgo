package me.algo.leetcode;

public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left= right;
        return root;
    }
}
}
