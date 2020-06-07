package me.algo.leetcode;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        CoinChange2 coinChange2 = new CoinChange2();
        System.out.println(coinChange2.change(amount, coins));
    }

    //    public int change(int amount, int[] coins) {
//        int[][] results = new int[coins.length + 1][amount + 1];
//        results[0][0] = 1;
//
//        for (int i = 1; i <= coins.length; i++) {
//            results[i][0] = 1;
//            for (int j = 1; j <= amount; j++) {
//                results[i][j] = results[i - 1][j] + (j >= coins[i - 1] ? results[i][j - coins[i - 1]] : 0);
//            }
//        }
//        return results[coins.length][amount];
//    }
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
