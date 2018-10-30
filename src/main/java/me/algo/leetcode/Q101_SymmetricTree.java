package me.algo.leetcode;

public class Q101_SymmetricTree {
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
		public TreeNode(int val, TreeNode left, TreeNode right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}
		 
	}
	 
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return checkNode(root.left, root.right);
    }
	
	public boolean checkNode(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		if(left.val != right.val) return false;
		return checkNode(left.left, right.right) && checkNode(left.right, right.left);
	}
	
	public static void main(String[] args) {
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(3);
		TreeNode node3 = new TreeNode(2, node6, node7);
		TreeNode node2 = new TreeNode(2, node4, node5);
		TreeNode node1 = new TreeNode(1, node2, node3);
		
		Q101_SymmetricTree sample = new Q101_SymmetricTree();
		System.out.println(sample.isSymmetric(node1));
		
	}
}
