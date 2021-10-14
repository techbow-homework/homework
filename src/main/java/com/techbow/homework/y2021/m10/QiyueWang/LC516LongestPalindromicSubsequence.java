package com.techbow.homework.y2021.m10.QiyueWang;

public class LC516LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = n - 1; i >= 0; i--){//determine traversal order, dp[i][j] depends on [i + 1, j - 1], i from large to small, j from small to large
            char cur = s.charAt(i);
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j++){
                if(cur == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        String s2 = "cbbd";
        System.out.println(longestPalindromeSubseq(s)); // 4
        System.out.println(longestPalindromeSubseq(s2)); // 2
    }
}
// time O(N^2) space O(N^2)
