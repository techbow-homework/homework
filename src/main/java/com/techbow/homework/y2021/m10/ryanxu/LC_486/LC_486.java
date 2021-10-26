package com.techbow.homework.y2021.m10.ryanxu.LC_486;

public class LC_486 {
    public boolean PredictTheWinner(int[] nums) {

        if (nums == null) {
            return false;
        }

        // dp[i][j]: player1 在[i, j]内可以取到的 和 的最大值
        // dp[i][j] = max(nums[i] + min(dp[i+2][j], dp[i+1][j-1]), nums[j] + min(dp[i+1][j-1], dp[i][j-2]))
        int numsLen = nums.length;
        int[][] dp = new int[numsLen][numsLen];
        int sum = 0;
        for (int len = 1; len <= numsLen; len++) {
            sum += nums[len - 1];
            for (int i = 0; i + len - 1 < numsLen; i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = nums[i];
                }
                int part1 = nums[i] + Math.min(i + 2 > j ? 0 : dp[i + 2][j], i + 1 > j - 1 ? 0 : dp[i + 1][j - 1]);
                int part2 = nums[j] + Math.min(i + 1 > j - 1 ? 0 : dp[i + 1][j - 1], i > j - 2 ? 0 : dp[i][j - 2]);
                dp[i][j] = Math.max(part1, part2);
            }
        }

        return dp[0][numsLen - 1] >= sum - dp[0][numsLen - 1];
    }

    public static void main(String[] args) {
        LC_486 lc_486 = new LC_486();
        int[] nums = {1,5,233,7};
        System.out.println(lc_486.PredictTheWinner(nums));
    }
}
