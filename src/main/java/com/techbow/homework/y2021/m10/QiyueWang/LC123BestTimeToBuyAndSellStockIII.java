package com.techbow.homework.y2021.m10.QiyueWang;

public class LC123BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3]; // dp[ith day][hold a stock or not][times sold]
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][0][1] = -100000; // not gonna happen
        dp[0][1][1] = -100000; // not gonna happen

        for(int i = 1; i < n; i++){
            dp[i][0][0] = dp[i - 1][0][0]; // not buying, not sold once
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]); // buy the first time
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]); // sell the first time
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]); // but the second time
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]); // sell the second time
        }
        return Math.max(dp[n - 1][0][1], dp[n - 1][0][2]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int[] prices2 = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices)); // 6
        System.out.println(maxProfit(prices2)); // 4
    }
}
// time O(N) space O(N)
