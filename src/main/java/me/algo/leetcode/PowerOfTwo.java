package me.algo.leetcode;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 2147483647;
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(n));
    }

//    public boolean isPowerOfTwo(int n) {
//        int i = 0;
//        while (true) {
//            double val = Math.pow(2, i);
//            if (val == n) {
//                return true;
//            } else if (val > n) {
//                return false;
//            }
//            i++;
//        }
//    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (-n)) == n;
    }
}
