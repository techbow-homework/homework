package com.techbow.homework.y2021.m09.boyuan;

public class LC_01 {
    public static int sum(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j - i >= 0; j--) {
                dp[ j ] += dp[ j - i ];
            }
        }
        return dp[n];
    }

    public static int findSum2(int N) {
        int[][] dp = new int[N + 1][N + 1];
        //i是当前物品的个数，j 是当前背包的容量
        //对于背包容量为0，1，2的所有情况都只有一种选择
        //对于一个dp[i][j]，要么当前i不放进去，满足的数量是dp[i-1][j],要么放进去，满足的数量是dp[i-1][j-c[i]]
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if ( j == 0) dp[i][j] = 1;
                if(i == 0) dp[i][j] = 0;
            }
        }
        dp[0][0] = 1;
        dp[1][1] = 1;
        dp[2][2] = 1;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (j < i) {
                    dp[i][j] = dp[j][j];
//                    System.out.println(j);
                }
                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - i];
            }
        }
//        for (int i = 0; i < N + 1; i++) {
//            for (int j = 0; j < N + 1; j++) {
//                System.out.println("i=" + i + " j=" + j + "  " + dp[i][j]);
//            }
//        }
        return dp[N][N];
    }

    public static void main(String[] args) {
        for (int i = 3; i <= 70; i++) {
            System.out.println("findSum2: " + findSum2(i) + ", sum: " + sum(i));
        }
    }

}
