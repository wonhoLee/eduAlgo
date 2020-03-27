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
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0 ; i < size; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left !=null) q.add(node.left);
                if(node.right !=null) q.add(node.right);
            }

            Integer tmp = level.get(0);
            for(Integer val : level){
                if(tmp < val){
                    tmp = val;
                }
            }
            ret.add(tmp);
        }

        return ret;
    }
}
