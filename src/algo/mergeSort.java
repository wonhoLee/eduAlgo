package algo;

import java.util.Arrays;

public class mergeSort {

	public static void main(String[] args) {
		//안경잡이 개발자 블로그
		//https://blog.naver.com/ndb796/221227934987
		int[] A = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
		int[] sorted = new int[A.length];
		mergeSort(A, 0, A.length - 1, sorted);
		System.out.println(Arrays.toString(sorted));
	}
	
	private static void mergeSort(int[] a, int m, int n, int[] sorted) {
		if(m < n) {
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
		
		while(i <= middle && j <= n) {
			if(a[i] <= a[j]) {
				sorted[k] = a[i];
				i++;
			}else {
				sorted[k] = a[j];
				j++;
			}
			k++;
		}
		
		if(i > middle) {
			for (int k2 = j; k2 <= n; k2++) {
				sorted[k] = a[k2];
				k++;
			}
		}else {
			for (int k2 = i; k2 <= middle; k2++) {
				sorted[k] = a[k2];
				k++;
			}
		}
		
		for (int k2 = m; k2 <= n; k2++) {
			a[k2] = sorted[k2]; 
		}
	}
	
	
	
}
