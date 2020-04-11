package me.algo.programmers;

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
}

