package me.algo.leetcode.bst;

import java.util.Stack;

public class InsertBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;

        InsertBST validateBST = new InsertBST();
        System.out.println(validateBST.insertIntoBST(root, 5));
        System.out.println("test");
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode valNode = new TreeNode(val);

        while (node != null) {
            if(node.val > val){
                if(node.left == null){
                    node.left = valNode;
                    return root;
                }else{
                    node = node.left;
                }
            }else{
                if(node.right == null){
                    node.right = valNode;
                    return root;
                }else{
                    node = node.right;
                }
            }
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (root.val > key) {
            root.left = insertIntoBST(root.left, key);
        } else {
            root.right = insertIntoBST(root.right, key);
        }
        return root;
    }
}
