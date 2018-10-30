package me.algo.leetcode;

public class Q70_ClimbingStairs {
	public int climbStairs(int n) {
		if(n<=0) return 0;
		if(n==1) return 1;
        int[] d = new int[n+1];
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
			d[i] = d[i-1] + d[i-2];
		}
        return d[n];
    }
}
