package me.algo.programmers;

import java.util.Arrays;
import java.util.Stack;

public class WonStudy {
    public static void main(String[] args) {
        int[] heights = {6, 9, 5, 7, 4};

        WonStudy wonStudy = new WonStudy();
        System.out.println(Arrays.toString(wonStudy.solution(heights)));
    }

    /*
    stack
    s 넣고
    while stack
        idx = stack.size
        for array reverse
        if(array[idx] > s.pop){
        result[idx] = fori;
        break;
        )
     */
    public int[] solution(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int[] answer = new int[heights.length];
        Arrays.fill(answer, 0);

        for (int val : heights) {
            s.push(val);
        }

        while (!s.empty()) {
            int idx = s.size() - 1;
            int cur = s.pop();
            for (int i = idx - 1; i >= 0; i--) {
                if (heights[i] > cur) {
                    answer[idx] = i + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
