package com.techbow.homework.y2021.m10.ryanxu.LC_188.v1;

public class LC_188v1 {
    public int maxProfit(int k, int[] prices) {

        if (k <= 0 || prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        // k does not affect max profit
        int[] newBoard = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            newBoard[i] = prices[i - 1];
        }
        if (k >= prices.length / 2) {
            int curBuy = 0;
            int curSell = 0;
            int preBuy = Integer.MIN_VALUE / 2;
            int preSell = 0;
            for (int i = 1; i <= len; i++) {
                curBuy = Math.max(preBuy, preSell - newBoard[i]);
                curSell = Math.max(preSell, preBuy + newBoard[i]);
                preBuy = curBuy;
                preSell = curSell;
            }
            return curSell;
        }

        // buy[i][j]: 第i天 buy,进行了j次交易
        // buy 的时候计算交易
        int[][] buy = new int[len + 1][k + 1];
        int[][] sell = new int[len + 1][k + 1];
        for (int j = 0; j <= k; j++) {
            buy[0][j] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - newBoard[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + newBoard[i]);
            }
        }

        return sell[len][k];
//        int res = Integer.MIN_VALUE;
//        for (int j = 1; j <= k; j++) {
//            res = Math.max(res, sell[len][j]);
//        }
//
//        return res;
    }

    public static void main(String[] args) {
        LC_188v1 lc_188v1 = new LC_188v1();
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        int k = 4;
        System.out.println(lc_188v1.maxProfit(k, prices));
    }
}
