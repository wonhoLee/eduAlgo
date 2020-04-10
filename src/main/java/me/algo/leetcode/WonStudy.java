package me.algo.leetcode;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.util.Locale;

public class WonStudy {

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String s = "test";
//        long x = 111111;
//        if(x>=-32768 && x<=32767){
//            System.out.println("* short");
//        }
//        if(x>=Integer.MIN_VALUE && x<=Integer.MAX_VALUE) System.out.println("* int");
//        if(x>=Long.MIN_VALUE && x<=Long.MAX_VALUE) System.out.println("* long");
//        int month = 8;
//        int day = 5;
//        int year = 2015;
//        System.out.println(LocalDate.of(year, month, day).getDayOfWeek().toString());
//        double payment = 12324.134;
//        NumberFormat usNf = NumberFormat.getCurrencyInstance(Locale.US);
//        String us = usNf.format(payment);
//        System.out.println(us);
//Locale indiaLocale = new Locale("en", "IN");

        String A = "test";
        String reverse = new StringBuffer(A).reverse().toString();

    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return sum;
        traversal(root);
        return sum;
    }

    public Boolean traversal(TreeNode node) {
        if (node.left != null) {
            if (traversal(node.left)) sum += node.left.val;
        }

        if (node.right != null) traversal(node.right);

        return (node.left == null) && (node.right == null);
    }
}
