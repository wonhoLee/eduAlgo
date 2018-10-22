package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q94_BinaryTreeInorderTraversal {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/*
	 * inOrder : left self right
	 * preOrder : self left right
	 * postOrder : left right self
	 */
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> ret = new ArrayList<>();
		
		traversal(root, ret);
		
		return ret;
	}
	
	public void traversal(TreeNode self, List<Integer> ret) {
		if(self == null) return;
		traversal(self.left, ret);
		ret.add(self.val);
		traversal(self.right, ret);
	}
}
