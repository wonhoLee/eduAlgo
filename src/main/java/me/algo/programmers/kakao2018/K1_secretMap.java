package me.algo.programmers.kakao2018;

import java.util.Arrays;

public class K1_secretMap {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		/*int n = 6;
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27, 56, 19, 14, 14, 10};*/
		/*int n = 1;
		int[] arr1 = {9};
		int[] arr2 = {30};*/
		
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}

	//CASE3: CASE1���� - ����
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
			answer[i] = answer[i].replaceAll("1", "#").replaceAll("0", " ");
		}
		
	    return answer;
	}
	
	//CASE2 : ����
	/*public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
			if(answer[i].length() != n) {
				int nTemp = n - answer[i].length();
				for (int j = 0; j < nTemp; j++) {
					answer[i] = "0" + answer[i];
				}
			}
			answer[i] = answer[i].replaceAll("1", "#").replaceAll("0", " ");
		}
		
	    return answer;
	}*/
	
	//CASE 1 : Ư�����̽��ϴ� ���������
	/*public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			answer[i] = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(arr1[i] | arr2[i])));
			answer[i] = answer[i].replaceAll("1", "#").replaceAll("0", " ");
		}
		
	    return answer;
	}*/
}
