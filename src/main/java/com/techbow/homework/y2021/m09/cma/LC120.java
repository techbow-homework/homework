package com.techbow.homework.y2021.m09.cma;

public class LC120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            Integer[][] dp = new Integer[triangle.size()][triangle.size()];
            return dfs(0,0, triangle, dp);
        }

        private int dfs(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
            int n = triangle.size();
            if (i == n) return 0;
            // 1
            if (dp[i][j] != null) return dp[i][j];


            int left = dfs(i + 1, j, triangle,dp);
            int right = dfs(i + 1, j + 1, triangle,dp);
            // 2
            dp[i][j] =  triangle.get(i).get(j) + Math.min(left, right);
            return dp[i][j];
        }

    }
}
