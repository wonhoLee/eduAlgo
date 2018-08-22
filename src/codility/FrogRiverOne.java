package codility;

import java.util.Arrays;

public class FrogRiverOne {

	public static void main(String[] args) {
		int[] A = {1,3,1,4,2,3,5,4};	//6
		int B = 5;
		//int B = 2;
		//int[] A = {2, 2, 2, 2, 2}; // -1
		//int B = 3;
		//int[] A = {1, 3, 1, 3, 2, 1, 3};	//4
		//int B = 1;
		//int[] A = {1};	//0
		System.out.println(solution(B, A));

	}

	private static int solution(int X, int[] A) {
		int nRet = -1;
		int nSum = 0;
		int[] alTemp = new int[X];
		Arrays.fill(alTemp, 0);
		
		for (int i = 0; i < A.length; i++) {
			if(alTemp[A[i]-1]==0) {
				alTemp[A[i]-1]++;
	            nSum=nSum+A[i];
	        }
			
			if(i>=(X-1)) {
				if(nSum == (X*(X+1)/2))
					return i;
			}
		}
		return nRet;
	}
	
	//case 2 : timeout 54
	/*private static int solution(int X, int[] A) {
		int nRet = -1;
		ArrayList<Integer> alOrigin = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
        	alOrigin.add(A[i]);
		}
		
		//OR
		//List<Integer> alOrigin =Arrays.stream(A).boxed().collect(Collectors.toList());
		
		for (int i = 1; i <= X; i++) {
			int nTemp = alOrigin.indexOf(i);
			if( nTemp == -1) {
				return -1;
			}
			if(nTemp > nRet) {
				nRet = nTemp;
			}
		}
		
		return nRet;
	}*/
	
	//CASE 1 : performance 45
	/*private static int solution(int X, int[] A) {
        int nRet = -1;
        ArrayList<Integer> alOrigin = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
        	alOrigin.add(A[i]);
		}
        
        int[] sorted = new int[A.length];
        if(A.length == 1) {
        	sorted[0] = A[0];
        }else {
        	mergeSort(A, 0, A.length - 1, sorted);
        }
		
		//연속된값 체크
		ArrayList<Integer> alTemp = new ArrayList<>();
		for (int i = 0; i < sorted.length; i++) {
			if(sorted[i] <= X) {
				if(!alTemp.contains(sorted[i])) {
					alTemp.add(sorted[i]);
				}
			}
		}
		
		if(alTemp.size() != X) {
			return -1;
		}
		
		for (int i = 0; i < alTemp.size(); i++) {
			int nTemp = alOrigin.indexOf(alTemp.get(i));
			if(nTemp > nRet) {
				nRet = nTemp;
			}
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
	}*/
}
