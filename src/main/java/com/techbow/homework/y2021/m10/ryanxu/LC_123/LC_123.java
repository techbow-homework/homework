package com.techbow.homework.y2021.m10.ryanxu.LC_123;

public class LC_123 {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int curBuy1 = 0;
        int curSell1 = 0;
        int preBuy1 = Integer.MIN_VALUE / 2;
        int preSell1 = 0;
        int curBuy2 = 0;
        int curSell2 = 0;
        int preBuy2 = Integer.MIN_VALUE / 2;
        int preSell2 = 0;
        for (int i = 0; i < len; i++) {
            curBuy1 = Math.max(preBuy1, -prices[i]);
            curSell1 = Math.max(preSell1, preBuy1 + prices[i]);
            preBuy1 = curBuy1;
            preSell1 = curSell1;
            curBuy2 = Math.max(preBuy2, preSell1 - prices[i]);
            curSell2 = Math.max(preSell2, preBuy2 + prices[i]);
            preBuy2 = curBuy2;
            preSell2 = curSell2;
        }

        return curSell2;
    }

    public static void main(String[] args) {
        LC_123 lc_123 = new LC_123();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(lc_123.maxProfit(prices));
    }
}
