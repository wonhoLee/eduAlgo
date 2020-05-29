package me.algo.leetcode;

import java.util.*;

public class Q207_CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{}};
        Q207_CourseSchedule courseSchedule = new Q207_CourseSchedule();
        System.out.println(courseSchedule.canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            visited.add(node);
            for (int dest : adjList.get(node)) {
                if (--indegree[dest] == 0) q.offer(dest);
            }
            adjList.get(node).clear();
        }
        return visited.size() == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i ++)
            graph[i] = new ArrayList<>();
        for (int[] pre : prerequisites)
            graph[pre[1]].add(pre[0]);
        // 0: not visited
        // 1: visiting
        // 2: visited
        int[] status = new int[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            if (status[i] == 0) {
                if (!topo(graph, status, i))
                    return false;
            }
        }
        return true;
    }
    public boolean topo(List<Integer>[] graph, int[] status, int cur) {
        if (status[cur] == 1)   return false;
        if (status[cur] == 2)   return true;
        status[cur] = 1;
        for (int next : graph[cur]) {
            if (!topo(graph, status, next))
                return false;
        }
        status[cur] = 2;
        return true;
    }
}
