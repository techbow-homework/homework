package com.techbow.homework.y2021.m10.zekun;

public class LC0005_LongestPalindrome {
    public String longestPalindrome(String s){
        //cc
        int len = s.length();
        if(s == null || len <= 2 ) return s;
        boolean[][] dp = new boolean[len][len];//dp: the maximum palindrome len between i and j;
        int maxLen = 1;
        int maxPalindromeBegin = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        dp[i][j] = true;
                    }else if(dp[i + 1][j - 1]){
                        dp[i][j] = true;
                    }

                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    maxPalindromeBegin = i;
                }
            }

        }
        return s.substring(maxPalindromeBegin, maxPalindromeBegin + maxLen);

    }
}
