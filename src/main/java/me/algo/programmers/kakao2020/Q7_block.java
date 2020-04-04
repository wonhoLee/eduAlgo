package me.algo.programmers.kakao2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/60063
//https://jennylee4517.github.io/ps/2020%EC%B9%B4%EC%B9%B4%EC%98%A4%EA%B3%B5%EC%B1%84-5/
public class Q7_block {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] rowToColDx = {-1, -1, 0, 0};
    static int[] rowToColDy = {0, 1, 0, 1};
    static int[] colToRowDx = {0, 1, 0, 1};
    static int[] colToRowDy = {0, 0, -1, -1};

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};

        Q7_block q7_block = new Q7_block();
        System.out.println(q7_block.solution(board));
    }

    public int solution(int[][] board) {
        int ret = Integer.MAX_VALUE;
        if (board == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(new TreeNode(0, 0, 0, 0));
        int size = board.length;
        int[][][] visited = new int[size][size][2]; // i, j에서 각 포지션(0, 1)에 따른 최소 도달 시간을 기록할 배열

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Arrays.fill(visited[i][j], 999999); // 큰 수로 초기화
            }
        }

        visited[0][0][0] = 0; // 처음 위치는 0초

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int x = node.x;
            int y = node.y;
            int t = node.t;
            int p = node.p;

            if ((x == size - 1 && y == size - 2 && p == 0) || (x == size - 2 && y == size - 1 && p == 1)) {
                if (t < ret) ret = t;
            }

            // 회전 없이 우좌하상으로 움직일때
            for (int k = 0; k < 4; k++) {
                if (k == 0) {
                    if (!canGoRight(x, y, p, board)) continue;
                } else if (k == 1) {
                    if (!canGoLeft(x, y, p, board)) continue;
                } else if (k == 2) {
                    if (!canGoDown(x, y, p, board)) continue;
                } else {
                    if (!canGoUp(x, y, p, board)) continue;
                }
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (visited[nx][ny][p] > t + 1) {
                    visited[nx][ny][p] = t + 1;
                    q.offer(new TreeNode(nx, ny, t + 1, p));
                }

            }
            // 가로로 놓인 상황인 경우 세로로 돌려보자
            if (p == 0) {
                for (int k = 0; k < 4; k++) {
                    if (k < 2) {
                        if (!canRotateUp(x, y, board)) continue; // 돌려서 윗칸을 침범하는 세로모양으로 만들기
                    } else {
                        if (!canRotateDown(x, y, board)) continue; // 돌려서 아랫칸을 침범하는 세로모양으로 만들기
                    }
                    int nx = x + rowToColDx[k];
                    int ny = y + rowToColDy[k];
                    if (visited[nx][ny][1] > t + 1) {
                        visited[nx][ny][1] = t + 1;
                        q.offer(new TreeNode(nx, ny, t + 1, 1));
                    }
                }
            }
            // 세로로 놓인 상황인 경우 가로로 돌려보자
            if (p == 1) {
                for (int k = 0; k < 4; k++) {
                    if (k < 2) {
                        if (!canRotateRight(x, y, board)) continue; // 돌려서 오른쪽칸을 침범
                    } else {
                        if (!canRotateLeft(x, y, board)) continue; // 돌려서 왼쪽칸을 침범
                    }
                    int nx = x + colToRowDx[k];
                    int ny = y + colToRowDy[k];
                    if (visited[nx][ny][0] > t + 1) {
                        visited[nx][ny][0] = t + 1;
                        q.offer(new TreeNode(nx, ny, t + 1, 0));
                    }
                }
            }
        }


        return ret;
    }

    static boolean canGoRight(int x, int y, int p, int[][] board) {
        int size = board.length;
        if (p == 0) {
            if (y + 2 >= size || board[x][y + 1] == 1 || board[x][y + 2] == 1)
                return false;
        } else {
            if (y + 1 >= size || x + 1 >= size || board[x][y + 1] == 1 || board[x + 1][y + 1] == 1)
                return false;
        }
        return true;
    }

    static boolean canGoLeft(int x, int y, int p, int[][] board) {
        int size = board.length;
        if (p == 0) {
            if (y - 1 < 0 || board[x][y - 1] == 1)
                return false;
        } else {
            if (y - 1 < 0 || x + 1 >= size || board[x][y - 1] == 1 || board[x + 1][y - 1] == 1)
                return false;
        }
        return true;
    }

    static boolean canGoDown(int x, int y, int p, int[][] board) {
        int size = board.length;
        if (p == 0) {
            if (x + 1 >= size || y + 1 >= size || board[x + 1][y] == 1 || board[x + 1][y + 1] == 1)
                return false;
        } else {
            if (x + 2 >= size || board[x + 1][y] == 1 || board[x + 2][y] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean canGoUp(int x, int y, int p, int[][] board) {
        int size = board.length;
        if (p == 0) {
            if (x - 1 < 0 || y + 1 >= size || board[x - 1][y] == 1 || board[x - 1][y + 1] == 1)
                return false;
        } else {
            if (x - 1 < 0 || board[x - 1][y] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean canRotateUp(int x, int y, int[][] board) {
        int size = board.length;
        if (x - 1 < 0 || y + 1 >= size || board[x - 1][y] == 1 || board[x - 1][y + 1] == 1)
            return false;
        return true;
    }

    static boolean canRotateDown(int x, int y, int[][] board) {
        int size = board.length;
        if (x + 1 >= size || y + 1 >= size || board[x + 1][y] == 1 || board[x + 1][y + 1] == 1)
            return false;
        return true;
    }

    static boolean canRotateRight(int x, int y, int[][] board) {
        int size = board.length;
        if (y + 1 >= size || x + 1 >= size || board[x][y + 1] == 1 || board[x + 1][y + 1] == 1)
            return false;
        return true;
    }

    static boolean canRotateLeft(int x, int y, int[][] board) {
        int size = board.length;
        if (y - 1 < 0 || x + 1 >= size || board[x][y - 1] == 1 || board[x + 1][y - 1] == 1)
            return false;
        return true;
    }

}

class TreeNode {
    int x;
    int y;
    int t;
    int p;

    TreeNode(int x, int y, int t, int p) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.p = p;
    }
}