package me.algo.leetcode.bst;

public class PreorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        preorderTraversal.bstFromPreorder(preorder);
    }

//    public TreeNode bstFromPreorder(int[] preorder){
//        if(preorder == null) return null;
//        TreeNode root = new TreeNode(preorder[0]);
//
//        for (int i = 1; i < preorder.length; i++) {
//            insertBST(root, preorder[i]);
//        }
//
//        return root;
//    }
//
//    public TreeNode insertBST(TreeNode root, int key){
//        if(root == null) return new TreeNode(key);
//        if(root.val > key){
//            root.left = insertBST(root.left, key);
//        }else{
//            root.right = insertBST(root.right, key);
//        }
//        return root;
//    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.val) break;
        }
        node.left = helper(preorder, start + 1, i - 1);
        node.right = helper(preorder, i, end);
        return node;
    }
}
