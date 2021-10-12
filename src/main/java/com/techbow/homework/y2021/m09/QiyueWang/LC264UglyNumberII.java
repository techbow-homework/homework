package com.techbow.homework.y2021.m09.QiyueWang;

public class LC264UglyNumberII {
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for(int i = 2; i <= n; i++){ // p_i = idx, points to the idx-th ugly number that hasn't been multiplied with i and get compared.
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if(dp[i] == num2) p2++;
            if(dp[i] == num3) p3++;
            if(dp[i] == num5) p5++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n)); // 12
    }
}
//time O(N) space O(N)
