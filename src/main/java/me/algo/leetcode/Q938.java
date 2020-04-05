package me.algo.leetcode;

//https://leetcode.com/problems/range-sum-of-bst/
//https://www.youtube.com/watch?v=ZFtl5Mrzb-I
public class Q938 {
    public static void main(String[] args) {

    }

    /*
    0. root == null return 0;
    1. root.val < L -> 오른쪽 섭트리만 탐색
    2. root.val > R -> 왼쪽 섭트리만 탐색
    3. L <= root.val <= R -> 왼쪽섭트리 + 내값 + 오른쪽 섭트리
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        else if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return rangeSumBST(root.left, L, R) + root.val + rangeSumBST(root.right, L, R);
        }
    }
}
