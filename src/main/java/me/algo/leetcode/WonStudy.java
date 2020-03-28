package me.algo.leetcode;

public class WonStudy {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return sum;
        traversal(root);
        return sum;
    }

    public Boolean traversal(TreeNode node) {
        if (node.left != null) {
            if (traversal(node.left)) sum += node.left.val;
        }

        if (node.right != null) traversal(node.right);

        return (node.left == null) && (node.right == null);
    }
}
