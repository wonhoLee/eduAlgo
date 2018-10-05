package me.algo.hackerrank;

import java.util.Arrays;

public class hard_ArrayManipulation {

	public static void main(String[] args) {
		int n = 5;
		int[][] queries = {{1, 2, 100}, {2,5,100},{3,4,100}};	//200
		//int n = 10;
		//int[][] queries = {{2, 6, 8}, {3, 5, 7},{1, 8, 1},{5, 9, 15}};	//31
		
		System.out.println(arrayManipulation(n, queries));
	}
	
	
	private static long arrayManipulation(int n, int[][] queries) {
		long nRet = 0;
		long[] arr = new long[n];
		Arrays.fill(arr, 0);
		
		for (int i = 0; i < queries.length; i++) {
			arr[queries[i][0] - 1] += queries[i][2];
			if(queries[i][1] < n) arr[queries[i][1]] -= queries[i][2];
		}
		
		long nTemp = 0;
		for (int i = 0; i < arr.length; i++) {
			nTemp += arr[i];
			if(nRet < nTemp) {
				nRet = nTemp;
			}
		}
		
		return nRet;
    }
	
	//�����Ͽ� Ǯ��
	/*private static long arrayManipulation(int n, int[][] queries) {
		long nRet = 0;
		long[] arr = new long[n];
		Arrays.fill(arr, 0);
		
		for (int i = 0; i < queries.length; i++) {
			arr[queries[i][0] - 1] += queries[i][2];
			if(queries[i][1] < n) arr[queries[i][1]] -= queries[i][2];
		}
		
		long nTemp = 0;
		for (int i = 0; i < arr.length; i++) {
			nTemp += arr[i];
			if(nRet < nTemp) {
				nRet = nTemp;
			}
		}
		
		return nRet;
    }*/

	//CASE 1 : ���� �� �ð��ʰ�
	/*private static long arrayManipulation(int n, int[][] queries) {
		long nRet = 0;
		int[] arr = new int[n];
		Arrays.fill(arr, 0);
		
		for (int i = 0; i < queries.length; i++) {
			for (int j = queries[i][0] - 1; j < queries[i][1]; j++) {
				arr[j] += queries[i][2];
				
				if(nRet < arr[j]) {
					nRet = arr[j];
				}
			}
		}
		
		return nRet;

    }*/
}
