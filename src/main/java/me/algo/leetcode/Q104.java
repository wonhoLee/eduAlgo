package me.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q104 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int maxDepth(TreeNode root) {
        int ret = 0;
        if(root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i< size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            ret++;
        }

        return ret;
    }
}
