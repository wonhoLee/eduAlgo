package me.algo.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class LV1_divideNum {

	public static void main(String[] args) {
		int[] arr = {5,9,7,10};
		int divisor = 5;
		
		System.out.println(Arrays.toString(solution(arr, divisor)));

	}

	private static int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		
		ArrayList<Integer> alTemp = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0) {
				alTemp.add(arr[i]);
			}
		}
		
		if(alTemp.size() == 0) {
			answer = new int[1];
			answer[0] = -1;
		}else {
			answer = new int[alTemp.size()];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = alTemp.get(i);
			}
			Arrays.sort(answer);
		}
		
		return answer;
	}
}
