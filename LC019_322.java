package com.teamblind.nygift75;


import java.util.Arrays;

public class LC019_322 {
    //    322. Coin Change
    //
    //    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
    //    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    //    You may assume that you have an infinite number of each kind of coin.

    static class SolutionA {
        static int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);

            int[] dp = new int[amount + 1];
            for (int i = 1; i < dp.length; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = coins.length - 1; j >= 0; j--) {
                    if (coins[j] > i) { continue; }
                    if (dp[i - coins[j]] == Integer.MAX_VALUE) { continue; }
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }

        public static void main(String[] args) {
            System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
//            System.out.println(coinChange(new int[]{1,2,5}, 6));
        }
    }
}
