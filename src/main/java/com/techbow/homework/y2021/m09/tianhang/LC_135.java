package com.techbow.homework.y2021.m09.tianhang;

public class LC_135 {
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];

        dp[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                dp[i] = dp[i - 1] + 1;
            } else{
                dp[i] = 1;
            }
        }

        for(int j = ratings.length - 1; j >= 1; j--){
            if(ratings[j] < ratings[j - 1] && dp[j] >= dp[j - 1]){
                dp[j - 1] = dp[j] + 1;
            }
            if(ratings[j] < ratings[j - 1] && dp[j] >= dp[j - 1]){
                dp[j - 1] = dp[j] + 1;
            }
        }
        int min = 0;
        for(int i = 0; i < dp.length; i++){
            min += dp[i];
        }
        return min;
    }
}
