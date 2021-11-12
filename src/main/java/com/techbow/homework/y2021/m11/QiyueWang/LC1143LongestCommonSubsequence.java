package com.techbow.homework.y2021.m11.QiyueWang;

public class LC1143LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];// max common subsequence till t1_i, t2_j

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    public static void main(String[] args) {
        String t1 = "abcde";
        String t2 = "bce";
        System.out.println(longestCommonSubsequence(t1,t2));//3
    }
}
//time O(mn) space O(mn)
