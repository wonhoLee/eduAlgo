package me.algo.algo.sort;

import java.util.Arrays;

public class Bubblesort {

	public static void main(String[] args) {
		int[] A = { 9, 5, 7, 3, 2, 7, 3, 1, 10, 8 };
		bubbleSort(A);
		bubbleSort2(A);
		wonstudy(A);
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort2(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]){
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	private static void wonstudy(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]){
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}