package me.algo.leetcode;


// Q202
public class Q202_HappyNumber {
    int nCnt = 0;

    public static void main(String[] args) {
        int num = 18;
        Q202_HappyNumber q202HappyNumber = new Q202_HappyNumber();
        System.out.println(q202HappyNumber.checkHappyNumber(num));
    }

    public boolean checkHappyNumber(int num) {
        if (num == 1) return true;
        if (nCnt >= 100) return false;
        int sumNum = 0;

        String[] temp = String.valueOf(num).split("");
        for (String targetStr : temp) {
            int targetNum = Integer.parseInt(targetStr);
            sumNum += targetNum * targetNum;
        }
        nCnt++;
        return checkHappyNumber(sumNum);
    }

}
