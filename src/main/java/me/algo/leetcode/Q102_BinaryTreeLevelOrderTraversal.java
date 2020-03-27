package me.algo.leetcode;

import java.util.*;

public class Q102_BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        Q102_BinaryTreeLevelOrderTraversal q102BinaryTreeLevelOrderTraversal = new Q102_BinaryTreeLevelOrderTraversal();
        System.out.println(q102BinaryTreeLevelOrderTraversal.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<TreeNode> s = new LinkedList<>();
        s.add(root);

        while(!s.isEmpty()){
            int size = s.size();
            List<Integer> level = new ArrayList<>();

            for(int i =0; i< size; i++){
                TreeNode node = s.poll();
                level.add(node.val);

                if(node.left != null) s.add(node.left);
                if(node.right != null) s.add(node.right);
            }

            ret.add(level);
        }

        return ret;
    }
}
