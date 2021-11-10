package com.techbow.homework.y2021.m10.ryanxu.LC_122;

public class LC_122 {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int curBuy = 0;
        int curSell = 0;
        int preBuy = Integer.MIN_VALUE / 2;
        int preSell = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            curBuy = Math.max(preBuy, preSell - prices[i]);
            curSell = Math.max(preSell, preBuy + prices[i]);
            preBuy = curBuy;
            preSell = curSell;
        }

        return curSell;
    }

    public static void main(String[] args) {
        LC_122 lc_122 = new LC_122();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(lc_122.maxProfit(prices));
    }
}
