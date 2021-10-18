package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_354 {
    public int maxEnvelopes(int[][] envelopes) {
        //把信封排序好，之后使用最长上升子序列，是300的原题
        int res = 0;
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0) return res;
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int c : dp) {
            res = Math.max(res, c);
        }
        return res;
    }
}
