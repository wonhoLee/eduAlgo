package me.algo.programmers;

import java.util.Arrays;

public class Network {
    public static void main(String[] args) {
        int n = 3;
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
//        int n = 4;
//        int[][] computers = {{1, 0, 0, 1}, {0, 1, 1, 1}, {0, 1, 1, 0}, {1, 1, 0, 1}};

        Network network = new Network();
        System.out.println(network.solution(n, computers));
    }

    /*
    110
    110
    001

    110
    111
    011

    1001
    0111
    0110
    1101

    arr 0 1 2
        1 1 1
     */
    public int solution(int n, int[][] computers) {
        if (computers == null) return 0;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(computers, i, visited);
            }
        }

        return cnt;
    }

    public void dfs(int[][] computers, int node, boolean[] visited){
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if(!visited[i] && computers[node][i] == 1){
                dfs(computers, i, visited);
            }
        }
    }

    public void bfs(int[][] computers, int x, int y, boolean[] visited) {
        if (computers[x][y] == 0 || computers[x][y] == 9) return;
        int size = computers.length;
        computers[x][y] = 9;
        visited[y] = true;

        if (x + 1 < size && computers[x + 1][y] == 1) {
            bfs(computers, x + 1, y, visited);
        }
        if (y + 1 < size && computers[x][y + 1] == 1) {
            bfs(computers, x, y + 1, visited);
        }
        if (x - 1 >= 0 && computers[x - 1][y] == 1) {
            bfs(computers, x - 1, y, visited);
        }
        if (y - 1 >= 0 && computers[x][y - 1] == 1) {
            bfs(computers, x, y - 1, visited);
        }
    }

//    public int solution(int n, int[][] computers) {
//        int answer = 0;
//        boolean[] visited = new boolean[n];
//        Arrays.fill(visited, false);
//
//        for (int i = 0; i < computers.length; i++) {
//            if(!visited[i]){
//                answer++;
//                dfs(i, visited, computers);
//            }
//        }
//
//        return answer;
//    }
//
//    public void dfs(int node, boolean[] visited, int[][] computers){
//        visited[node] = true;
//
//        for (int i = 0; i < computers.length; i++) {
//            if(!visited[i] && computers[node][i] == 1){
//                dfs(i, visited, computers);
//            }
//        }
//    }
}


