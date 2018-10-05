package me.algo.codility;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		//int[] A = {1, 3, 6, 4, 1, 2};	//5
		//int[] A = {1, 2, 3};	//4
		int[] A = {-1, -3};	//1
		
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
        int nRet = 1;
        Arrays.sort(A);
        
        for (int i = 0; i < A.length; i++) {
			if(A[i] == nRet) {
				nRet++;
			}else if(A[i] > nRet){
				return nRet;
			}
		}
        
        return nRet;
    }
}
