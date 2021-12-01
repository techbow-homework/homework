package com.techbow.homework.y2021.m10.ryanxu.LC_97;

public class LC_97 {
    public boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }

        // dp[i][j]: whether s3[0 : i+j] is formed by an interleaving of s1[0:i] and s2[0:j]
        // move s1 and s2 to right for one idx
        String ss1 = "#" + s1;
        String ss2 = "#" + s2;
        String ss3 = "#" + s3;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] && ss3.charAt(i) == ss1.charAt(i);
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] && ss3.charAt(j) == ss2.charAt(j);
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char cur1 = ss1.charAt(i);
                char cur2 = ss2.charAt(j);
                char cur3 = ss3.charAt(i + j);
                if (cur3 == cur1 && dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (cur3 == cur2 && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LC_97 lc_97 = new LC_97();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(lc_97.isInterleave(s1, s2, s3));
    }
}
