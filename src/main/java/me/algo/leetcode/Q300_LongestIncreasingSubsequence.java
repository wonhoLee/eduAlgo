package me.algo.leetcode;

public class Q300_LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		//점화식
		//d[i] = 나를 포함하는 가장 긴 LIS의 길이
		int[] d = new int[nums.length];
		d[0] = 1;
		
		for (int i = 0; i < nums.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && d[j] > max) {
					max = d[j];
				}
			}
			d[i] = max+1;
		}
		
		int max = d[0];
		for (int i = 0; i < nums.length; i++) {
			if(d[i]>max) max = d[i];
		}
		return max;
    }

	public static void main(String[] args) {
		
	}
}
