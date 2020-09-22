package me.algo.algo.sort;

import java.util.Arrays;

//https://blog.naver.com/ndb796/221227934987
public class MergeSort {

	public static void main(String[] args) {
		int[] array = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
		int[] sorted = new int[array.length];
//		mergeSort(A, 0, A.length - 1, sorted);
		wonSort(array, 0, array.length - 1, sorted);
		System.out.println(Arrays.toString(sorted));
	}

	private static void mergeSort(int[] array, int low, int high, int[] sorted) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(array, low, middle, sorted);
			mergeSort(array, middle + 1, high, sorted);
			merge(array, sorted, low, middle, high);
		}
	}

	private static void merge(int[] array, int[] helper, int low, int middle, int high) {
		// 절반짜리 두 배열을 helper 배열에 복사한다.
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		//helper 배열 순회, 왼쪽 절반과 오른쪽 절반을 비교하여 작은 원소를 원래 배열에 복사해 넣는다.
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {    //오른쪽 원소가 왼쪽 원소보다 작으면
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		// 왼쪽 절반 배열에 남은 원소들을 원래 배열에 복사해 넣는다.
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}

//	private static void merge(int[] array, int low, int middle, int high, int[] sorted) {
//		int helperLeft = low;
//		int helperRight = middle + 1;
//		int current = low;
//
//		while (helperLeft <= middle && helperRight <= high) {
//			if (array[helperLeft] <= array[helperRight]) {
//				sorted[current] = array[helperLeft];
//				helperLeft++;
//			} else {
//				sorted[current] = array[helperRight];
//				helperRight++;
//			}
//			current++;
//		}
//
//		if (helperLeft > middle) {
//			for (int k2 = helperRight; k2 <= high; k2++) {
//				sorted[current] = array[k2];
//				current++;
//			}
//		} else {
//			for (int k2 = helperLeft; k2 <= middle; k2++) {
//				sorted[current] = array[k2];
//				current++;
//			}
//		}
//
//		for (int k2 = low; k2 <= high; k2++) {
//			array[k2] = sorted[k2];
//		}
//	}

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
