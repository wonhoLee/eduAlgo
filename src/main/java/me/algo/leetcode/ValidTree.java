package me.algo.leetcode;

public class ValidTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(0);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;

        int[] arr = {0, 1, 0, 1};
        ValidTree validTree = new ValidTree();
        System.out.println(validTree.isValidSequence(root, arr));
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return recursion(root, arr, 0);
    }

    public boolean recursion(TreeNode node, int[] arr, int idx) {
        if (node == null) return false;
        if (idx == arr.length) return false;
        if (node.val != arr[idx]) return false;
        if (idx == arr.length - 1 && node.left == null && node.right == null) return true;
        boolean l = false;
        boolean r = false;

        if (node.left != null) l = recursion(node.left, arr, idx + 1);
        if (node.right != null) r = recursion(node.right, arr, idx + 1);

        if (l || r) return true;
        return false;
    }
}
