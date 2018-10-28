package me.algo.algo;

import java.util.Arrays;

public class Sudoku {
	public void solveSudoku(char[][] board) {
		backTrack(board, 0);
	}
	
	public boolean backTrack(char[][] board, int idx) {
		if(idx == 81) return true;
		int row = idx / 9;
		int col = idx % 9;
		char cur = board[row][col];
		if(cur != '.') {
			return backTrack(board, idx+1);
		}else {
			for (int i = 1; i < 9; i++) {
				board[row][col] = (char)(i + '0');
				if(isValidSudoku(board)) {
					boolean b = backTrack(board, idx+1);
					if(b) return b;
				}
			}
			board[row][col] = ',';
			return false;
		}
	}
	
	public boolean isValidSudoku(char[][] board) {
		boolean[] b = new boolean[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				Arrays.fill(b, false);
				for (int k = 0; k < 9; k++) {
					char cur;
					if(i == 0) { //가로
						cur = board[j][k];
					}else if(i == 1) {	//세로
						cur = board[k][j];
					}else {	//서브그리드
						cur = board[j / 3 * 3 + k / 3][j % 3 * 3 + k % 3];
					}
					if(cur == '.') continue;
					int val = Character.getNumericValue(cur);
					if(b[val - 1]) return false;
					b[val-1] = true;
				}
			}
		}
		
		return true;
    }
	
	public static void main(String[] args) {
//		for (int j = 0; j < 9; j++) {
//			for (int k = 0; k < 9; k++) {
//				System.out.println("j : " + j + " k : " + k + ", j / 3 * 3 + k / 3 : " + j / 3 * 3 + k / 3 + ", j % 3 * 3 + k % 3 : " + j % 3 * 3 + k % 3);
//			}
//		}
		
		int i = 1;
		char c = (char)(i + '0');
		System.out.println(c);
		
	}
}
