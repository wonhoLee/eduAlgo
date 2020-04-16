package me.algo.programmers.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelPath {
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ICN"}, {"ATL", "JFK"}};
        String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"} , {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
//        String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
        TravelPath travelPath = new TravelPath();
        System.out.println(Arrays.toString(travelPath.solution(tickets)));
    }

    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        Arrays.fill(visited, false);
        List<String> ret = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            } else {
                return o1[0].compareTo(o2[0]);
            }
        });

//        for (String[] str : tickets) {
//            System.out.println(Arrays.toString(str));
//        }

        dfs(tickets, visited, "ICN", ret, temp, 0);

        return ret.stream().toArray(String[]::new);
    }

    public boolean dfs(String[][] tickets, boolean[] visited, String lastCity, List<String> ret, List<String> temp, int n) {
        temp.add(lastCity);
        if (n == tickets.length) {
            boolean tempFlag = true;
            for (boolean vi : visited) {
                if (!vi) {
                    tempFlag = false;
                    break;
                }
            }
            if (tempFlag) {
                ret.addAll(temp);
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] tic = tickets[i];
            if (!visited[i] && lastCity.equals(tic[0])) {
                visited[i] = true;
                if (!dfs(tickets, visited, tic[1], ret, temp, n + 1)) {
                    visited[i] = false;
                } else {
                    return true;
                }
            }
        }

        temp.remove(temp.size() - 1);
        return false;
    }
}
