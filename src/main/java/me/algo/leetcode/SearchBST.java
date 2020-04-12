package me.algo.leetcode;

public class SearchBST {
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

        SearchBST searchBST = new SearchBST();
        TreeNode node = searchBST.searchBST(root, 2);
        if(node == null){
            System.out.println("null");
        }else{
            System.out.println(node.val);
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;

        TreeNode l = searchBST(root.left, val);
        TreeNode r = searchBST(root.right, val);
        if(l != null) return l;
        if(r != null) return r;

        return null;
    }
}
