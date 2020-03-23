package me.algo.programmers.kakao2020;

//https://programmers.co.kr/learn/courses/30/lessons/60059
public class Q3_lockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
//        int[][] lock = {{1, 1, 1}, {0, 1, 1}, {1, 1, 0}};

        Q3_lockAndKey q3_lockAndKey = new Q3_lockAndKey();
        System.out.println(q3_lockAndKey.solution(key, lock));
    }

    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;

        int[][] copyLock = new int[N * 3][N * 3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyLock[i + N][j + N] = lock[i][j];
            }
        }

        return dfs(key, copyLock, 0);
    }

    public boolean dfs(int[][] key, int[][] lock, int cnt) {
        if (check(key, lock, 0, 0)) return true;
        if (cnt >= 4) return false;
        int[][] temp = rotation(key);
        return dfs(temp, lock, cnt + 1);
    }

    public boolean check(int[][] key, int[][] lock, int x, int y) {
        if (y + key.length > lock.length) {
            y = 0;
            x++;
        }
        if (x + key.length > lock.length) return false;

        int[][] copyLock = new int[lock.length][lock.length];
        System.arraycopy(lock, 0, copyLock, 0, lock.length);

        boolean isFail = false;
        loop:
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (key[i][j] == 1) {
                    if (copyLock[i + x][j + y] == 1) { // Lock 이 돌기면 false 처리
                        isFail = true;
                        break loop;
                    }
                    copyLock[i + x][j + y] = key[i][j]; // Key 값을 copy -> lock 은 모두 1처리가 목표
                }
            }
        }
        if (!isFail) {
            loop:
            for (int i = 0; i < lock.length / 3; i++) {
                for (int j = 0; j < lock.length / 3; j++) {
                    if (copyLock[i + lock.length / 3][j + lock.length / 3] != 1) {  //Lock 1이 아닐경우 false 처리
                        isFail = true;
                        break loop;
                    }
                }
            }
        }
        if (!isFail) {
            return true;
        }
        return check(key, lock, x, y + 1);
    }

    public int[][] rotation(int[][] arr) {
        int arrCnt = arr.length;
        int[][] temp_arr = new int[arrCnt][arrCnt];

        // 90도 회전
        for (int i = 0; i < arrCnt; i++) {
            for (int j = 0; j < arrCnt; j++) {
                temp_arr[i][j] = arr[arrCnt - 1 - j][i];
            }
        }

        return temp_arr;
    }
}
