package me.algo.programmers;

import java.util.Arrays;

public class LV1_numReverse {

	public static void main(String[] args) {
		long n = 123450;
		System.out.println(Arrays.toString(solution(n)));
	}

	/*private static int[] solution(long n) {
		String[] saTemp = Long.toString(n).split("");
		int[] answer = new int[saTemp.length];
		for (int i = 0; i < saTemp.length; i++) {
			answer[i] = Integer.parseInt(saTemp[saTemp.length - 1 - i]);
		}
		
		return answer;
	}*/
	
	private static int[] solution(long n) {
		StringBuilder sb = new StringBuilder(Long.toString(n));
		return Arrays.stream(sb.reverse().toString().split("")).mapToInt(i -> Integer.parseInt(i)).toArray();
	}
	
	//CASE 1 : �����ؼ� �Ǽ�, ������ �ƴ� �׳� ���� ������ ���� ��_��;
	/*public static int[] solution(long n) {
		return bubbleSortDes(
				Arrays
				.stream(Long.toString(n).split(""))
				.mapToInt(i->Integer.parseInt(i))
				.toArray());
	}
	
	private static int[] bubbleSortDes(int[] arr) {
	    int temp = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j= 1 ; j < arr.length-i; j++) {
				if(arr[j]>arr[j-1]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}*/
}
