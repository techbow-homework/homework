package com.techbow.homework.y2021.m09.QiyueWang;

public class LC121BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min = 100000;
        int max = 0;
        for(int i = 0; i < n; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{7,6,5,4,3,2,1};
        System.out.println(maxProfit(prices)); // 5
        System.out.println(maxProfit(prices2)); // 0
    }
}
// time O(N) space O(1)