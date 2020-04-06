package me.algo.leetcode;

//Q122
public class Q122_BestTime {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        Q122_BestTime q122BestTime = new Q122_BestTime();
        System.out.println(q122BestTime.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                ret += diff;
            }
        }
        return ret;
    }
}
