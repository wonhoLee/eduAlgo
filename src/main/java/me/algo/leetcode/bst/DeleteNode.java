package me.algo.leetcode.bst;

public class DeleteNode {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            root.val = getRight(root.left);
            root.left = deleteNode(root.left, root.val);
        }else if(root.val > key){
            root.left= deleteNode(root.left, key);
        }else{
            root.right= deleteNode(root.right, key);
        }
        return root;
    }

    public int getRight(TreeNode root) {
        int min = 0;
        while(root != null){
            min = root.val;
            root = root.right;
        }
        return min;
    }
}
