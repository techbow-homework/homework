package com.techbow.homework.y2021.m09.tingtingtang;

public class LC01 {
    // easy solution；time complexity O(N^2)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
