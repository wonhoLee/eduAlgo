package me.algo.hackerrank;

import java.util.Arrays;

public class BreakingtheRecords {

	public static void main(String[] args) {
		int[] nTarget = {10, 5, 20, 20, 4, 5, 2, 25, 1};
		//int[] nTarget = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
		System.out.println(Arrays.toString(breakingRecords(nTarget)));
	}

	public static int[] breakingRecords(int[] scores) {
		int nMin = scores[0];
		int nMax = scores[0];
		int nMinCnt = 0;
		int nMaxCnt = 0;
		
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > nMax) {
				nMax = scores[i];
				nMaxCnt++;
			}
			if (scores[i] < nMin) {
				nMin = scores[i];
				nMinCnt++;
			}
		}
	
		int[] nRet = {nMaxCnt, nMinCnt};
		return nRet;
    }
}
