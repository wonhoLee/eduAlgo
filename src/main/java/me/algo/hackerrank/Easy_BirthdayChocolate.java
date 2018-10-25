package me.algo.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Easy_BirthdayChocolate {

	public static void main(String[] args) {
		List<Integer> nTarget = new ArrayList<>();
		int d = 0;
		int m = 0;
		/*int[] nTarget = {2,2,1,3,2};
		d = 4;
		m = 2;*/
		/*int[] nTarget = {1,2,1,3,2};
		d = 3;
		m = 2;*/
		/*int[] nTarget = {1,1,1,1,1};
		d = 3;
		m = 2;*/
		/*nTarget.add(4);
		d = 4;
		m = 1;*/
		System.out.println(birthday(nTarget, d, m));
	}

	private static int birthday(List<Integer> s, int d, int m) {
		int nRet = 0;
		int nCnt = 1;
		int nSum = 0;
		
		if(s.size() > 1) {
			for (int i = 0; i < s.size() - 1; i++) {
				nSum = s.get(i);
				for (int j = i + 1; j < s.size(); j++) {
					if(nCnt < m) {
						nSum += s.get(j);
						nCnt++;
					}else {
						break;
					}
				}
				if(nSum == d) {
					nRet++;
				}
				nCnt = 1;
			}
		}else {
			if(s.get(0) == d) {
				nRet++;
			}
		}
		
		return nRet;
	}
}
