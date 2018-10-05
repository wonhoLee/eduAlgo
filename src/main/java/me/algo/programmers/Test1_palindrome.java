package me.algo.programmers;

import java.util.Arrays;

public class Test1_palindrome {

	public static void main(String[] args) {
		int n = 1;
		int m = 100;
		
		System.out.println(solution(n,m));
	}
	
	public static int solution(int n, int m) {
        int answer = 0;
        
        for (int i = n; i < m; i++) {
			if(isPan(i)) {
				answer++;
			}
		}

        return answer;
    }
	
	public static boolean isPan(int nInput) {
		boolean bRet = false;
		String sTarget1 = String.valueOf(nInput);
		StringBuilder sb = new StringBuilder(String.valueOf(nInput));
		String sTarget2 = sb.reverse().toString();
		if(sTarget1.equals(sTarget2)) {
			bRet = true;
		}
		return  bRet;
	}

}
