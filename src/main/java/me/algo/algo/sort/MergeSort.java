package me.algo.algo.sort;

import java.util.Arrays;

//https://blog.naver.com/ndb796/221227934987
public class MergeSort {

	public static void main(String[] args) {
		int[] A = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
		int[] sorted = new int[A.length];
//		mergeSort(A, 0, A.length - 1, sorted);
		wonSort(A, 0, A.length - 1, sorted);
		System.out.println(Arrays.toString(sorted));
	}

	private static void mergeSort(int[] a, int m, int n, int[] sorted) {
		if (m < n) {
			int middle = (m + n) / 2;
			mergeSort(a, m, middle, sorted);
			mergeSort(a, middle + 1, n, sorted);
			merge(a, m, middle, n, sorted);
		}
	}

	private static void merge(int[] a, int m, int middle, int n, int[] sorted) {
		int i = m;
		int j = middle + 1;
		int k = m;

		while (i <= middle && j <= n) {
			if (a[i] <= a[j]) {
				sorted[k] = a[i];
				i++;
			} else {
				sorted[k] = a[j];
				j++;
			}
			k++;
		}

		if (i > middle) {
			for (int k2 = j; k2 <= n; k2++) {
				sorted[k] = a[k2];
				k++;
			}
		} else {
			for (int k2 = i; k2 <= middle; k2++) {
				sorted[k] = a[k2];
				k++;
			}
		}

		for (int k2 = m; k2 <= n; k2++) {
			a[k2] = sorted[k2];
		}
	}

	private static void wonSort(int[] source, int start, int end, int[] target) {
		if (start < end) {
			int middle = (start + end) / 2;
			wonSort(source, start, middle, target);
			wonSort(source, middle + 1, end, target);
			wonMerger(source, start, middle, end, target);
		}
	}

	private static void wonMerger(int[] source, int start, int middle, int end, int[] target) {
		int i = start;
		int j = middle + 1;
		int k = start;

		while (i <= middle && j <= end) {
			if (source[i] <= source[j]) {
				target[k] = source[i];
				i++;
			} else {
				target[k] = source[j];
				j++;
			}
			k++;
		}

		if (i > middle) {
			for (int l = j; l <= end; l++) {
				target[k] = source[l];
				k++;
			}
		} else {
			for (int l = i; l <= middle; l++) {
				target[k] = source[l];
				k++;
			}
		}

		for (int l = start; l <= end; l++) {
			source[l] = target[l];
		}
	}
}
