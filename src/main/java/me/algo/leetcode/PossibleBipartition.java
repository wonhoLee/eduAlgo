package me.algo.leetcode;

import java.util.*;

public class PossibleBipartition {
    public static void main(String[] args) {
        int N = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        System.out.println(possibleBipartition.possibleBipartition(N, dislikes));
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int[] arr : dislikes) {
            List<Integer> list = hashMap.containsKey(arr[0]) ? hashMap.get(arr[0]) : new ArrayList<>();
            list.add(arr[1]);
            hashMap.put(arr[0], list);
            list = hashMap.containsKey(arr[1]) ? hashMap.get(arr[1]) : new ArrayList<>();
            list.add(arr[0]);
            hashMap.put(arr[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    List<Integer> temp = hashMap.get(cur);
                    if (temp == null) continue;
                    for (Integer next : temp) {
                        if (visited[next] == visited[cur]) return false;
                        if (visited[next] == 0) {
                            visited[next] = -visited[cur];
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        return true;
    }
}
