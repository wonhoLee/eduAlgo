package me.algo.programmers.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class Top {
    public static void main(String[] args) {
//        int[] heights = {6,9,5,7,4};
//        int[] heights = {3,9,9,3,5,7,2};
        int[] heights = {1,5,3,6,7,6,5};
        Top top = new Top();
        System.out.println(Arrays.toString(top.solution(heights)));
    }

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        answer[0] = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i < heights.length; i++) {
            if(heights[i-1] > heights[i]){
                answer[i] = i;
                s.push(i);
            }else{
                if(!s.empty()){
                    if(heights[s.peek()-1] > heights[i]) {
                        answer[i] = s.peek();
                    }else {
                        s.pop();
                        answer[i] = 0;
                    }
                }
            }
        }

        return answer;
    }

    /*
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
     */
}

