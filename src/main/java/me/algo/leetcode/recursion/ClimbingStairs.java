package me.algo.leetcode.recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 2;
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(n));
    }

    public int climbStairs(int n) {
        return helper(0, n);
    }

    public int helper(int i, int n) {
        if (i > n) return 0;
        if (i == n) return 1;
        return helper(i + 1, n) + helper(i + 2, n);
    }

    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return helper2(0, n, memo);
    }

    public int helper2(int i, int n, int[] memo) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] > 0) return memo[i];
        memo[i] = helper2(i + 1, n, memo) + helper2(i + 2, n, memo);
        return memo[i];
    }

    public int climbStairs3(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
