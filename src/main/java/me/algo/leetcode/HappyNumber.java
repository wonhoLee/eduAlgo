package me.algo.leetcode;


// Q202
public class HappyNumber {
    int nCnt = 0;

    public static void main(String[] args) {
        int num = 18;
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.checkHappyNumber(num));
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
