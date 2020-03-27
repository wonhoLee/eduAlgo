package me.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int tmp = Integer.MIN_VALUE;
            for(int i=0 ; i < size; i++){
                TreeNode node = q.poll();
                if(tmp > node.val) tmp = node.val;
                if(node.left !=null) q.offer(node.left);
                if(node.right !=null) q.offer(node.right);
            }
            ret.add(tmp);
        }

        return ret;
    }
}
