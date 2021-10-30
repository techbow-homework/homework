package com.techbow.homework.y2021.m10.ryanxu.LC_188;

public class LC_188v2 {
    public int maxProfit(int k, int[] prices) {

        if (k <= 0 || prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int maxPrice = 0;
        for (int i = 0; i < len; i++) {
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        int start = 0; // fee
        int end = maxPrice; // fee

        // 这里求的是 小于等于k的最大值
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val[] = maxProfitWithFee(prices, mid);
            if (val[1] > k){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        int[] val = maxProfitWithFee(prices, start);
//        return val[0] + start * val[1];
//        System.out.println();
        return val[0] + start * k;
    }

    private int[] maxProfitWithFee(int[] prices, int fee) {

        int len = prices.length;
        int[] newBoard = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            newBoard[i] = prices[i - 1];
        }

        int[] buy = new int[len + 1];
        int[] sell = new int[len + 1];
        int countBuy = 0; // 在buy的时候记录
        int countSell = 0;
        buy[0] = Integer.MIN_VALUE / 2;
        sell[0] = 0;
        for (int i = 1; i <= len; i++) {
            if (buy[i - 1] >= sell[i - 1] - newBoard[i] - fee) {
                buy[i] = buy[i - 1];
            } else {
                buy[i] = sell[i - 1] - newBoard[i] - fee;
                countBuy = countSell + 1;
            }
            if (sell[i - 1] >= buy[i - 1] + newBoard[i]) {
                sell[i] = sell[i - 1];
            } else {
                sell[i] = buy[i - 1] + newBoard[i];
                countSell = countBuy;
            }
        }

        return new int[]{sell[len], countSell}; // [maxProfit, Xm]
    }

    public static void main(String[] args) {
        LC_188v2 lc_188V2 = new LC_188v2();
        int[] prices = {3,3,5,0,0,3,1,4};
        int k = 2;
        System.out.println(lc_188V2.maxProfit(k, prices));
//        System.out.println(lc_188V2.maxProfitWithFee(prices, 2)[0]);
    }
}
