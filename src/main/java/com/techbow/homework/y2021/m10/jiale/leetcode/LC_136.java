package com.techbow.homework.y2021.m10.jiale.leetcode;

/**
 * Single number
 * Given an array of integers, every element appears twice except for one. Find single one.
 * 11233 xor with 0
 * 10212
 */
public class LC_136 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("empty input");
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
