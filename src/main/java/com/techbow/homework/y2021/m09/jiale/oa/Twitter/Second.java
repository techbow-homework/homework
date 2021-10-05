package com.techbow.homework.y2021.m09.jiale.oa.Twitter;

import java.util.List;

class Second {

    /*
     * Complete the 'largestArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY samples as parameter.
     */

    public static int largestArea(List<List<Integer>> samples) {
        // Write your code here
        int rows = samples.size(), cols = rows > 0 ?  samples.get(0).size() : 0;
        int[][] dp = new int[rows+1][cols+1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (samples.get(i-1).get(j-1)==1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]), dp[i-1][j-1])+1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen;
    }

}