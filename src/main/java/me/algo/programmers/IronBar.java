package me.algo.programmers;

import java.util.Stack;

public class IronBar {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        IronBar ironBar = new IronBar();
        System.out.println(ironBar.solution(arrangement));
    }

    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == '(') {
                st.push(i);
            } else if (arrangement.charAt(i) == ')') {
                if (st.peek() + 1 == i) {
                    st.pop();
                    answer += st.size();
                } else {
                    st.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }

//    public int solution(String arrangement) {
//        int answer = 0;
//
//        String[] arrangeArr = arrangement.replace("()", "0").split("");
//        Stack<String> stack = new Stack<>();
//
//        for (String arr : arrangeArr) {
//            if (arr.equals("(")) {
//                stack.push(arr);
//            } else if (arr.equals(")")) {
//                stack.pop();
//                answer++;
//            } else if (arr.equals("0")) {
//                answer += stack.size();
//            }
//        }
//
//        return answer;
//    }
}
