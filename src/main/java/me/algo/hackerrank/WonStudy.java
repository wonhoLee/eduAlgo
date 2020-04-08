package me.algo.hackerrank;

public class WonStudy {
    public static void main(String[] args) {
        String A = "hello";
        String B = "java";

        System.out.println(A.length() + B.length());
        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println(A.substring(0, 1).toUpperCase() + A.subSequence(1, A.length()) + " " +
                B.substring(0, 1).toUpperCase() + B.substring(1, B.length()));
    }

}
