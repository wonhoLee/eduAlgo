package me.algo.programmers.graph;

import java.util.Arrays;

public class WordChange {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        WordChange wordChange = new WordChange();
        System.out.println(wordChange.solution(begin, target, words));
    }

//    public int solution(String begin, String target, String[] words) {
//        int answer = 0;
//
//        Queue<String> q = new LinkedList<>();
//        boolean[][] visited = new boolean[words.length][words.length];
//        Arrays.fill(visited, false);
//        q.offer(words[0]);
//
//        for (int i = 0; i < ; i++) {
//
//        }
//
//        while(!q.isEmpty()){
//            String str = q.poll();
//
//            if(str.equals(target)){
//                break;
//            }
//
//            for (int i = 0; i < words.length; i++) {
//                if(!visited[i] && checkStr(begin, words[i])){
//                    begin = str;
//                    answer++;
//                    visited[i] = true;
//                    q.offer(words[i]);
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }

    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        for (String word:words) {
            if(target.equals(word)){
                flag = true;
                break;
            }
        }
        if(!flag) return 0;

        boolean[] visited = new boolean[words.length];
        Arrays.fill(visited, false);

        answer = Integer.MAX_VALUE;
        dfs(words, visited, begin, target, 0);
        return answer;
    }

    int answer;
    public void dfs(String[] words, boolean[] visited, String begin, String target, int n) {
        if(begin.equals(target)){
            answer = Math.min(answer, n);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && checkStr(begin, words[i])){
                begin = words[i];
                visited[i] = true;
                dfs(words, visited, begin, target, n+1);
            }
        }
    }

    public boolean checkStr(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        if (cnt == 1) {
            return true;
        } else {
            return false;
        }
    }
}
