package me.algo.leetcode;

public class Q230_KthSmallestElementInABST {
	/*
	 * in : left self right
	 * pre : self left right
	 * post : left right self
	 */
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
	
//	public int kthSmallest(TreeNode root, int k) {
//		List<Integer> list = new ArrayList<>();
//		traversal(root, list);
//		
//		int[] array = new int[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			array[i] = list.get(i);
//		}
//		
//		Arrays.sort(array);
//		
//		return array[k - 1];
//    }
	//Binary Tree 특성 : inorder 로 traversal 했을시 sorted list 가 나옴
	
//	public int kthSmallest(TreeNode root, int k) {
//		List<Integer> list = new ArrayList<>();
//		traversal(root, list);
//		return list.get(k - 1);
//    }
//	
//	public void traversal(TreeNode self, List<Integer> list) {
//		if(self == null) return;
//		traversal(self.left, list);
//		list.add(self.val);
//		traversal(self.right, list);
//	}
	
	int k;
	int cnt;
	int ret;
	boolean b;
	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		this.cnt = 0;
		this.ret = 0;
		this.b = false;
		traversal(root);
		return ret;
    }
	
//	public void traversal(TreeNode self) {
//		if(self == null) return;
//		traversal(self.left);
//		cnt ++;
//		if(cnt == k) this.ret = self.val;
//		traversal(self.right);
//	}
	
	public boolean traversal(TreeNode self) {
		if(b) return b;
		if(self == null) return false;
		b = traversal(self.left);
		cnt ++;
		if(cnt == k) {
			this.ret = self.val;
			return true;
		}
		return traversal(self.right);
	}
	
	public static void main(String[] args) {
		TreeNode testCase4 = new TreeNode(2, null, null);
		TreeNode testCase2 = new TreeNode(1, null, testCase4);
		TreeNode testCase3 = new TreeNode(4, null, null);
		TreeNode testCase1 = new TreeNode(3, testCase2, testCase3);
		
		Q230_KthSmallestElementInABST testCase = new Q230_KthSmallestElementInABST();
		System.out.println(testCase.kthSmallest(testCase1, 1));
	}
}
