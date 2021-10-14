package com.techbow.homework.y2021.m10.zhiren;

public class LC_70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[4];
        dp[0] = 1;
        dp[1] = 2;
        //int id1 = 0, 1 = 1, id3 = 2;
        for (int i = 3; i <= n; i++) {
            dp[2] = dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[1];
    }

    public static void main(String args[]){
        LC_70 lc = new LC_70();

        int n = 5;
        System.out.println(lc.climbStairs(n));
    }

}
