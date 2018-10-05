package me.algo.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class Test3_busstop {

	public static void main(String[] args) {
		/*int n = 3;
		int[][] signs = {{0,1,0},{0,0,1},{1,0,0}};*/
		int n = 3;
		int[][] signs = {{0,0,1},{0,0,1},{0,1,0}};
		
		int[][] answer = solution(n, signs);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}
		
	}

	private static int[][] solution(int n, int[][] signs){
        int[][] answer = {{0,0,0},{0,0,0},{0,0,0}};
        
        HashMap<Integer, Integer> hTemp = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if(signs[i][j] == 1) {
        			hTemp.put(i, j);
        		}
			}
		}
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if(getPass(hTemp, i, j)) {
        			answer[i][j] = 1;
        		}
			}
		}
        
        return answer;
    }
	
	private static boolean getPass(HashMap<Integer, Integer> hInput, int i, int j) {
		while(true) {
			if(!hInput.containsKey(i)) {
				return false;
			}
			if(!hInput.containsValue(j)) {
				return false;
			}
			if(hInput.get(i) == j) {
				return true;
			}else {
				return getPass(hInput, hInput.get(i), j);
			}
		}
	}
}
