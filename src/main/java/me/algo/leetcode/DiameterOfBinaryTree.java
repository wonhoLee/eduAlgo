package me.algo.leetcode;

import java.util.Stack;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode root = new TreeNode(1);
        node2.left = node4;
        node2.right = node5;
        root.left = node2;
        root.right = node3;

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));
    }

//    public int diameterOfBinaryTree(TreeNode root) {
//        if(root == null) return 0;
//
//        int rootLeft = traversal(root.left);
//        int rootRight = traversal(root.right);
//
//        int depthLeft = diameterOfBinaryTree(root.left);
//        int depthRight = diameterOfBinaryTree(root.right);
//
//        return Math.max(rootLeft + rootRight,
//                Math.max(depthLeft, depthRight));
//    }
//
//    public int traversal(TreeNode node){
//        if(node == null) return 0;
//
//        return 1 + Math.max(traversal(node.left), traversal(node.right));
//    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if(node == null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        ans = Math.max(ans, l+r+1);
        return Math.max(l, r) + 1;
    }



}
