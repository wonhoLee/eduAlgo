package me.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q404 {
    public static void main(String[] args) {
//        TreeNode node5 = new TreeNode(7);
//        TreeNode node4 = new TreeNode(15);
//        TreeNode node3 = new TreeNode(20, node4, node5);
//        TreeNode node2 = new TreeNode(9);
//        TreeNode root = new TreeNode(3, node2, node3);

//        TreeNode node3 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(0);
//        TreeNode root = new TreeNode(1, node2, node3);

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        Q404 q404 = new Q404();
        System.out.println(q404.sumOfLeftLeaves2(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int ret = 0;
        if (root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.offer(node.left);
                    if (node.left.left == null && node.left.right == null) ret += node.left.val;
                }
                if (node.right != null) q.offer(node.right);
            }

        }

        return ret;
    }

    //https://www.youtube.com/watch?v=g16fLbVcK0U&t=223s
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root != null) traverse(root);
        return sum;
    }

    int sum = 0;

    public boolean traverse(TreeNode node) {
        if (node.left != null) {
            boolean isLeaf = traverse(node.left);
            if (isLeaf) sum += node.left.val;
        }
        if (node.right != null) traverse(node.right);
        return node.left == null && node.right == null;
    }
}
