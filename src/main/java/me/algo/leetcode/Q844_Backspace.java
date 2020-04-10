package me.algo.leetcode;

import java.util.Stack;

public class Q844_Backspace {
    public static void main(String[] args) {
//        String S = "ab#c";
//        String T = "ab#c";
        String S = "y#fo##f";
        String T = "y#f#o##f";
        Q844_Backspace q844Backspace = new Q844_Backspace();
        System.out.println(q844Backspace.backspaceCompare(S, T));
    }

    public boolean backspaceCompare(String S, String T) {
        return getCheckString(S).equals(getCheckString(T));
    }

    public String getCheckString(String S){
        Stack<Character> stack = new Stack<>();

        for(char c : S.toCharArray()){
            if(c != '#'){
                stack.add(c);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }

//    public List<String> getCheckString(String S){
//        List<String> sList = new ArrayList<>();
//        int idx = 0;
//        for (int i = 1; i <= S.length(); i++) {
//            String str = S.substring(i - 1, i);
//
//            if (idx != 0 && str.equals("#")) {
//                sList.remove(idx - 1);
//                idx--;
//            } else if (!str.equals("#")){
//                sList.add(str);
//                idx++;
//            }
//        }
//        return sList;
//    }
}
