package me.algo.leetcode;

import java.util.Arrays;

public class Q37_SudokuSolver {
	public void solveSudoku(char[][] board) {
		backtrack(board, 0);
    }
	
	public boolean backtrack(char[][] board, int idx) {
		if(idx == 81) return true;
		int row = idx / 9;
		int col = idx % 9;
		char cur = board[row][col];
		if(cur != '.') {
			return backtrack(board, idx + 1);
		}else {
			for (int i = 1; i <= 9; i++) {
				board[row][col] = (char)(i + '0');
				if(isValidSudoku(board)) {
					boolean b = backtrack(board, idx+1);
					if(b) return b;
				}
			}
			board[row][col] = '.';
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
		Q37_SudokuSolver sample = new Q37_SudokuSolver();
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
		sample.solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		
	}
}
