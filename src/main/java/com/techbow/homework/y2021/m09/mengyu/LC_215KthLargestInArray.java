package com.techbow.homework.y2021.m09.mengyu;

import java.util.Arrays;

public class LC_215KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
