package me.algo.leetcode;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
//        String s = "(*))";
//        String s = ")(";
//        String s = "(*)";
//        String s = "((*)";
//        String s = "(())";
        String s = "(*)";
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString(s));
    }

    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    cnt++;
                }
            }else if(s.charAt(i) == '*'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty() && cnt == 0){
            return true;
        }else{
            return false;
        }
    }
}