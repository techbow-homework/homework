package com.techbow.homework.y2021.m12.jiale.leetcode;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class LC322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * dp[i] is the minimum number of coins needed to make change for amount S using coin denomations [c0...cn-1]
     **/
    public int coinChange(int[] coins, int amount, int[] dp)  {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount -1] != 0) {
            return dp[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, dp);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        dp[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount -1];
    }

    public int recursiveCoinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = recursiveCoinChange(coins, amount - coin);
            if (res != -1) {
                minCoins = Math.min(res+1, minCoins);
            }
        }
        return minCoins == Integer.MAX_VALUE ? -1: minCoins;
    }
}
