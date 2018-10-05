package me.algo.codility;

public class TapeEquilibrium {

	public static void main(String[] args) {
		//int[] A = {3,1,2,4,3};
		int[] A = {-1000, 1000};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int nRet = 0;
		int nCalc = 0;
		int[] naAccuNum = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			if(i == 0) {
				naAccuNum[i] = A[i];
			}else {
				naAccuNum[i] = naAccuNum[i - 1] + A[i];
			}
		}
		
		for (int i = 0; i < A.length - 1; i++) {
			nCalc = Math.abs(naAccuNum[i] - (naAccuNum[naAccuNum.length - 1] - naAccuNum[i]));
			if(i == 0) {
				nRet = nCalc;
			}else {
				if(nRet > nCalc) {
					nRet = nCalc;
				}
			}
		}
		
		return nRet;
    }
	
	//CASE 1 : ����ó�� ���� : 41��
		/*public static int solution(int[] A) {
			int nRet = 0;
			int nSum = 0;
			
			for (int i = 0; i < A.length; i++) {
				nSum += A[i];
			}
			nRet = nSum;
			
			int nTempValue = 0;
			int nTempValue2 = 0;
			for (int i = 0; i < A.length-1; i++) {
				nTempValue += A[i];
				nTempValue2 = nSum - nTempValue - nTempValue;
				
				if(nRet > Math.abs(nTempValue2)) {
					nRet = Math.abs(nTempValue2);
				}
			}
			
			return nRet;
	    }*/
	
	//CASE 2 : Performance ���� : 50��
	/*public static int solution(int[] A) {
		int nRet = 0;
		int nCalc = 0;
		
		int nAccuNum = 0;
		int nSumNum = 0;
		for (int i = 0; i < A.length - 1; i++) {
			nSumNum = 0;
			for (int j = i + 1; j < A.length; j++) {
				nSumNum += A[j];
			}
			nAccuNum += A[i];
			nCalc = Math.abs(nAccuNum - nSumNum);
			//System.out.println("nAccuNum : " + nAccuNum + " nSumNum : " + nSumNum + " nCalc : " + nCalc);
			if(nRet == 0 || nRet > nCalc) {
				nRet = nCalc;
			}
		}
		
		return nRet;
    }*/
	//CASE 3 : ������� �ʱⰪ ���� : 83��	
	/*public static int solution(int[] A) {
		int nRet = 0;
		int nCalc = 0;
		int[] naAccuNum = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			if(i == 0) {
				naAccuNum[i] = A[i];
			}else {
				naAccuNum[i] = naAccuNum[i - 1] + A[i];
			}
		}
		
		System.out.println(Arrays.toString(naAccuNum));
		
		for (int i = 0; i < A.length - 1; i++) {
			nCalc = Math.abs(naAccuNum[i] - (naAccuNum[naAccuNum.length - 1] - naAccuNum[i]));
//			System.out.println("nAccuNum : " + naAccuNum[i] + " nSumNum : " + (naAccuNum[naAccuNum.length - 1] - naAccuNum[i]) + " nCalc : " + nCalc);
			if(nRet == 0 || nRet > nCalc) {
				nRet = nCalc;
			}
		}
		
		return nRet;
    }*/
}
