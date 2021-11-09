package com.techbow.homework.y2021.m11.QiyueWang;

public class LC96UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;// initialization for convenience
        dp[1] = 1;
        for(int i = 2; i <= n; i ++){
            for(int j = 1; j <= i; j++){// j for choice of root
                dp[i] += dp[j - 1] * dp[i - j];// num of left * num of right
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(1));//1
        System.out.println(numTrees(3));//5
        System.out.println(numTrees(5));//42
    }
}
