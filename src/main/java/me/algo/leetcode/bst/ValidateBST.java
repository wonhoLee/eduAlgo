package me.algo.leetcode.bst;

import java.util.Stack;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(root));

    }

    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper){
        if(node == null) return true;

        int val = node.val;
        if(lower != null && val <= lower) return false;
        if(upper != null && val >= upper) return false;

        if(! helper(node.right, val, upper)) return false;
        if(! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        double inorder = Double.MIN_VALUE;

        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }

        return true;
    }
}
