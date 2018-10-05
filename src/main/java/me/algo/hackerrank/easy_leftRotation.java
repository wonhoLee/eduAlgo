package me.algo.hackerrank;

import java.util.Arrays;

public class easy_leftRotation {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int d = 4;
		System.out.println(Arrays.toString(rotLeft(a, d)));
	}

	private static int[] rotLeft(int[] a, int d) {
		for (int i = 0; i < d; i++) {
			int nTemp = a[0];
			for (int j = 0; j < a.length - 1; j++) {
				a[j] = a[j + 1];
			}
			a[a.length - 1] = nTemp;
		}
		return a;
    }
}
