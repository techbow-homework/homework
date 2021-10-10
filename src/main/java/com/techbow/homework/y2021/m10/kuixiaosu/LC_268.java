package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_268 {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            sum = sum + nums[i];
        }
        return (n * n + n) / 2 - sum;
    }
}
