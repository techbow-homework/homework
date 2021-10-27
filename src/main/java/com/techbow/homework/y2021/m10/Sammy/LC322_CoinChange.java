package com.techbow.homework.y2021.m10.Sammy;

import java.util.HashMap;

public class LC322_CoinChange {
    public int coinChange(int[] coins, int amount){
        //dp
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                int curCoin = coins[j];
                if(i >= curCoin && dp[i - curCoin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-curCoin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    //dfs + memo
    public int coinChangeDFS(int[] coins, int amounts){
        //cc
        if(coins == null || coins.length == 0) return 0;
        return coinChange(coins, amounts, new HashMap<Integer, Integer>);
    }
    private int coinChange(int[] coins, int amounts, HashMap<Integer,Integer> memo){
        if(memo.containsKey(amounts)){
            return memo.get(amounts);
        }
        if(amounts < 0) return -1;
        if(amounts == 0) return 0;
        int res = -1;
        for(int e: coins){
            int curBalance = amounts - e;
            int temp = coinChange(coins, curBalance, memo);
            if(temp != -1 && (res == -1 || temp + 1 < res)){
                res = temp + 1;
            }
        }
        memo.put(amounts, res);
        return res;
    }
}
