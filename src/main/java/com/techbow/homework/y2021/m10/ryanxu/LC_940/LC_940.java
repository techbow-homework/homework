package com.techbow.homework.y2021.m10.ryanxu.LC_940;

public class LC_940 {
    public int distinctSubseqII(String s) {

        if (s == null) {
            return 0;
        }

        int strLen = s.length();
        String ss = "#" + s;
        int[] dp = new int[strLen + 1];
        dp[0] = 1; // 这里的dp 包含 null的情况，所以dp[0] = 1
        int[] last = new int[26];
        int M = (int) (1e9 + 7);
        for (int i = 1; i <= strLen; i++) {
            int j = last[ss.charAt(i) - 'a'];
            dp[i] = (dp[i - 1] * 2 % M - (j - 1 >= 0 ? dp[j - 1] : 0) + M) % M;
            last[ss.charAt(i) - 'a'] = i;
        }

        return dp[strLen] - 1;
    }

    public static void main(String[] args) {
        LC_940 lc_940 = new LC_940();
        System.out.println(lc_940.distinctSubseqII("aba"));
    }
}
