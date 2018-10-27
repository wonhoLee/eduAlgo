package me.algo.leetcode;

import java.util.Arrays;

public class Q36_ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean[] b = new boolean[9];
		//룰의 종류, 가로, 세로, 섭그리드
		for (int i = 0; i < 3; i++) {
			//한줄의 규칙
			for (int j = 0; j < 9; j++) {
				Arrays.fill(b, false);
				for (int k = 0; k < 9; k++) {
					char cur = '.';
					if(i == 0) {		//가로
						cur = board[j][k];
					}else if(i == 1) {	//세로
						cur = board[k][j];
					}else {				//섭그리드
						cur = board[j / 3 * 3 + k / 3][j % 3 * 3 + k % 3];
					}
					if(cur == '.') continue;
					int val = Character.getNumericValue(cur);
					if(b[val-1]) return false;
					b[val-1] = true;
				}
			}
		}
        return true;
    }
	
	public static void main(String[] args) {
		Q36_ValidSudoku sample = new Q36_ValidSudoku();
		char[][] board = {
				  {'5','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		System.out.println(sample.isValidSudoku(board));
	}
}
