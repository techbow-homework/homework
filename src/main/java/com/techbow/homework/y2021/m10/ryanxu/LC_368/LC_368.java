package com.techbow.homework.y2021.m10.ryanxu.LC_368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        int len = nums.length;
        int[] dp = new int[len];
        int[] prev = new int[len];
        int idx = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            prev[i] = -1;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == dp[j] + 1) {
                        prev[i] = j;
                    }
                    if (maxLen < dp[i]) {
                        maxLen = dp[i];
                        idx = i;
                    }
                }
            }
        }


        while (prev[idx] != -1) {
            res.add(nums[idx]);
            idx = prev[idx];
        }
        res.add(nums[idx]);

        return res;
    }
}
