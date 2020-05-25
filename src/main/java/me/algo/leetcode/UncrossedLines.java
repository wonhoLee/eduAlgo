package me.algo.leetcode;

import java.util.Arrays;

public class UncrossedLines {
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 1, 2};
        int[] B = {1, 3, 2, 3, 1};
        UncrossedLines uncrossedLines = new UncrossedLines();
        System.out.println(uncrossedLines.maxUncrossedLines(A, B));
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[lenA][lenB];
    }

}
