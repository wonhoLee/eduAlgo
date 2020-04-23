package me.algo.leetcode;

public class Bitwise {
    public static void main(String[] args) {
//        int m = 5;   int n = 7;
        int m = 3; int n = 3;
        Bitwise bitwise = new Bitwise();
        System.out.println(bitwise.rangeBitwiseAnd(m, n));

    }
    /*
    0101
    0110
    0111
    */
//    public int rangeBitwiseAnd(int m, int n) {
//        int res = 0; // Initialize result
//
//        while (m > 0 && n > 0) {
//
//            // Find positions of MSB in x and y
//            int msb_p1 = msbPos(m);
//            int msb_p2 = msbPos(n);
//
//            // If positions are not same, return
//            if (msb_p1 != msb_p2)
//                break;
//
//            // Add 2^msb_p1 to result
//            int msb_val = (1 << msb_p1);
//            res = res + msb_val;
//
//            // subtract 2^msb_p1 from x and y.
//            m = m - msb_val;
//            n = n - msb_val;
//        }
//
//        return res;
//    }
//
//    private int msbPos(int n) {
//
//        int msb_p = -1;
//        while (n > 0) {
//            n = n >> 1;
//            msb_p++;
//        }
//
//        return msb_p;
//    }

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while(m < n){ // when equals 0, stop
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}
