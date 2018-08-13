package codility;

import java.util.Arrays;

public class MaxCounters {

	public static void main(String[] args) {
		int[] A = {3,4,4,6,1,4,4};
		int N = 5;
		System.out.println(Arrays.toString(solution(N, A)));
	}

	private static int[] solution(int N, int[] A) {
        int[] nRet = new int[N];
        int nMax = 0;
        Arrays.fill(nRet, 0);

        for (int i = 0; i < A.length; i++) {
			if(A[i] == (N + 1)) {
				Arrays.fill(nRet, nMax);
			}else {
				nRet[A[i] - 1] = nRet[A[i] - 1] + 1;
				if(nMax < nRet[A[i] - 1]) {
					nMax = nRet[A[i] - 1];
				}
			}
		}
        
        return nRet;
    }
	
	//Case 2: Time out 77
	/*private static int[] solution(int N, int[] A) {
        int[] nRet = new int[N];
        int nMax = 0;
        Arrays.fill(nRet, 0);

        for (int i = 0; i < A.length; i++) {
			if(A[i] == (N + 1)) {
				Arrays.fill(nRet, nMax);
			}else {
				nRet[A[i] - 1] = nRet[A[i] - 1] + 1;
				if(nMax < nRet[A[i] - 1]) {
					nMax = nRet[A[i] - 1];
				}
			}
		}
        
        return nRet;
    }*/
	
	//Case 1: Time out 66
	/*private static int[] solution(int N, int[] A) {
        int[] nRet = new int[N];
        
        for (int i = 0; i < nRet.length; i++) {
			nRet[i] = 0;
		}

        for (int i = 0; i < A.length; i++) {
			if(A[i] == (N + 1)) {
				int nMaxValue = 0;
				for (int j = 0; j < nRet.length; j++) {
					if(nRet[j] > nMaxValue) {
						nMaxValue = nRet[j];
					}
				}
				for (int j = 0; j < nRet.length; j++) {
					nRet[j] = nMaxValue;
				}
			}else {
				nRet[A[i] - 1] = nRet[A[i] - 1] + 1;
			}
		}
        
        return nRet;
    }*/
}
