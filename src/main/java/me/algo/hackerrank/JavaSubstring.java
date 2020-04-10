package me.algo.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class JavaSubstring {
    public static void main(String[] args) {
        String s = "welcometojava";
        int k = 3;
        JavaSubstring javaSubstring = new JavaSubstring();
        System.out.println(javaSubstring.getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

//        java.util.List<String> list = new java.util.ArrayList<>();
//        for (int i = 0; i <= s.length()-k; i++) {
//            list.add(s.substring(i, i+k));
//        }
//        list.stream().sorted();
//        smallest = list.get(list.size()-1);
//        largest = list.get(0);
        java.util.SortedSet<String> set = new java.util.TreeSet<>();
        for (int i = 0; i <= s.length()-k; i++) {
            set.add(s.substring(i, i+k));
        }
        smallest = set.first();
        largest = set.last();

        return smallest + "\n" + largest;
    }
}
