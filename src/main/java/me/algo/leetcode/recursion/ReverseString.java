package me.algo.leetcode.recursion;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(s);
    }

    public void reverseString(char[] s) {
        recursion(s, 0, s.length - 1);
        System.out.println(Arrays.toString(s));
    }

    public void recursion(char[] s, int source, int target){
        if(source >= target) return;

        char tmp = s[source];
        s[source] = s[target];
        s[target] = tmp;

        recursion(s, ++source, --target);
    }
}
