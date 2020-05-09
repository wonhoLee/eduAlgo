package me.algo.leetcode;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 16;
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(num));
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midSqr = mid * mid;
            if (midSqr == num) {
                return true;
            } else if (midSqr < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
