package me.algo.programmers;

import java.util.Arrays;

public class LV1_divideNum2 {

	public static void main(String[] args) {
		//int[] arr = {5,9,7,10};
		//int divisor = 5;
		
		//int[] arr = {2,36,1,3};
		//int divisor = 1;
		
		int[] arr = {3,2,6};
		int divisor = 10;
		
		System.out.println(Arrays.toString(solution(arr, divisor)));

	}

	private static int[] solution(int[] arr, int divisor) {
		int[] nTemp = Arrays.stream(arr).filter(factor -> factor % divisor ==0).sorted().toArray();
		
		if(nTemp.length == 0) {
			nTemp = new int[1];
			nTemp[0] = -1;
		}
		
		return nTemp;
	}
}
