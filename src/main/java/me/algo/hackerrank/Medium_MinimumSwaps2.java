package me.algo.hackerrank;

public class Medium_MinimumSwaps2 {

	public static void main(String[] args) {
		//int[] arr = {4,3,1,2};	//3
		//int[] arr = {2,3,4,1,5};	//3
		int[] arr = {1,3,5,2,4,6,8};	//3
		System.out.println(minimumSwaps(arr));
	}

	private static int minimumSwaps(int[] arr) {
		int nRet = 0;
		int nFlag = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j= i + 1; j < arr.length; j++) {
				if(arr[j] == nFlag) {
					nRet++;
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					break;
				}
			}
			
			nFlag++;
		}
		
		return nRet;
	}
}
