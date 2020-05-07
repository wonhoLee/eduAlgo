package me.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;

        int x = 2;
        int y = 3;

        CousinsInBT cousinsInBT = new CousinsInBT();
        System.out.println(cousinsInBT.isCousins(root, x, y));
    }

//    public boolean isCousins(TreeNode root, int x, int y) {
//        RNode xNode = helper(root, x, -1, 0);
//        RNode yNode = helper(root, y, -1, 0);
//        return xNode.getParentVal() != yNode.getParentVal() && xNode.getCnt() == yNode.getCnt();
//    }
//
//    public RNode helper(TreeNode root, int find, int parentVal, int cnt) {
//        if (root == null) return new RNode(-1, -1);
//        if (root.val == find) return new RNode(parentVal, cnt);
//
//        RNode l = helper(root.left, find, root.val, cnt + 1);
//        RNode r = helper(root.right, find, root.val, cnt + 1);
//
//        if(l.getCnt() > r.getCnt()){
//            return l;
//        }else{
//            return r;
//        }
//    }
//
//    static class RNode{
//        private final int parentVal;
//        private final int cnt;
//
//        public RNode(int parentVal, int cnt) {
//            this.parentVal = parentVal;
//            this.cnt = cnt;
//        }
//
//        public int getParentVal() {
//            return parentVal;
//        }
//
//        public int getCnt() {
//            return cnt;
//        }
//    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            boolean siblings = false;
            boolean cousins = false;

            int nodesAtDepth = q.size();

            for (int i = 0; i < nodesAtDepth; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    siblings = false;
                } else {
                    if (node.val == x || node.val == y) {
                        if (!cousins) {
                            siblings = cousins = true;
                        } else {
                            return !siblings;
                        }
                    }

                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                    q.add(null);
                }
            }
            if (cousins) return false;
        }
        return false;
    }
}
