package com.teamblind.nygift75;

public class LC003_121 {

    // 121. Best Time to Buy and Sell Stock
    // You are given an array prices where prices[i] is the price of a given stock on the ith day.
    // You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
    // future to sell that stock.
    // Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    static class SolutionA {
        public static int maxProfit(int[] prices) {

            int sellPrice = prices[0];
            int buyPrice = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < buyPrice) {
                    buyPrice = prices[i];
                    sellPrice = Integer.MIN_VALUE;
                    continue;
                }

                if (prices[i] > sellPrice) {
                    sellPrice = prices[i];
                    maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
                }
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(LC003_121.SolutionA.maxProfit(input));
    }
}
