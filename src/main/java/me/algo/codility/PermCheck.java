package me.algo.codility;

import java.time.Duration;
import java.time.LocalDateTime;

public class PermCheck {

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		//int[] A = {4,1,3,2};
		//int[] B = {4,1,3};
		
		int[] A = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
		System.out.println(solution(A));
		
		System.out.println(Duration.between(date, LocalDateTime.now()));
		//System.out.println(solution(B));
	}
	
	private static int solution(int[] A) {
        int nRet = 0;
        
        //Arrays.sort(A);
        int[] sorted = new int[A.length];
		mergeSort(A, 0, A.length - 1, sorted);
		
		for (int i = 1; i < sorted.length; i++) {
			if(sorted[i - 1] == sorted[i]) {
				return 0;
			}
		}
		
		if(A.length == A[A.length - 1]) {
        	nRet = 1;
        }
        return nRet;
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
	
	//case 1 : wrong answer : 83
	/*private static int solution(int[] A) {
        int nRet = 0;
        
        Arrays.sort(A);
        if(A.length == A[A.length - 1]) {
        	nRet = 1;
        }
        return nRet;
    }*/
	
	//case 2 : time out : 58
	/*private static int solution(int[] A) {
        int nRet = 0;
        ArrayList<Integer> alTemp = new ArrayList<>();
        
        Arrays.sort(A);
        
        for (int i = 0; i < A.length; i++) {
        	if(!alTemp.contains(A[i])) {
        		alTemp.add(A[i]);
        	}
		}
        
        if(A.length == A[A.length - 1] && A.length == alTemp.size()) {
        	nRet = 1;
        }
        return nRet;
    }*/

}
