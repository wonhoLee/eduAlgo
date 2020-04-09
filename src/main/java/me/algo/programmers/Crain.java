package me.algo.programmers;

import java.util.Stack;

public class Crain {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Crain crain = new Crain();
        System.out.println(crain.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int val = board[i][move - 1];
                if (val != 0) {
                    System.out.println(val);
                    if (!s.empty() && s.lastElement() == val) {
                        s.pop();
                        answer += 2;
                    } else {
                        s.push(val);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
