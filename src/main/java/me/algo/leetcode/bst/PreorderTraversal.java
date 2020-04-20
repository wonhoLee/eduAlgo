package me.algo.leetcode.bst;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        preorderTraversal.bstFromPreorder(preorder);
    }

//    public TreeNode bstFromPreorder(int[] preorder) {
//        if (preorder == null) return null;
//
//        TreeNode root = new TreeNode(preorder[0]);
//        TreeNode node = root;
//        List<Integer> testList = new ArrayList<>();
//        testList.add(preorder[0]);
//
//        for (int i = 1; i < preorder.length; i++) {
//
//        }
//    }
    public int[] bstFromPreorder(int[] preorder){
        
    }
}
