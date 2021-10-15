package com.techbow.homework.y2021.m10.QiyueWang;

public class LC279PerfectSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = i; // worst case add 1 each time
            for(int j = 1; i - j*j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n1 = 12;
        int n2 = 13;
        System.out.println(numSquares(n1));//3, 4+4+4
        System.out.println(numSquares(n2));//2, 4+9
    }
}
//time O(Nsqrt(N)) space O(N)
