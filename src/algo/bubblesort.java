package algo;

import java.util.Arrays;

public class bubblesort {

	public static void main(String[] args) {
		int[] A = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
		bubbleSort(A);
	}

	private static void bubbleSort(int[] arr) {
	    int temp = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j= 1 ; j < arr.length-i; j++) {
				if(arr[j]<arr[j-1]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
