package me.algo.hackerrank;

public class Easy_BubbleSort {

	public static void main(String[] args) {
		//int[] a = {3, 2, 1};
		int[] a = {1, 2, 3};
		solution(a);
	}

	private static void solution(int[] a) {
		int nCnt = 0;
		for (int i = 0; i < a.length; i++) {
		    for (int j = 0; j < a.length - 1; j++) {
		        // Swap adjacent elements if they are in decreasing order
		        if (a[j] > a[j + 1]) {
		        	nCnt ++;
		        	int nTemp = a[j];
		        	a[j] = a[j + 1];
		        	a[j+1] = nTemp;
		        }
		    }
		}
		
		System.out.println("Array is sorted in " + nCnt + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);
	}
}
