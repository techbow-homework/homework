package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int start = 0;
        int end = nums.length - 1;
        int curr = 0;
        while (start < end && curr <= end) {
            if (nums[curr] == 0) {
                nums[curr] = nums[start];
                nums[start] = 0;
                start++;
                curr++;
            } else if (nums[curr] == 2) {
                nums[curr] = nums[end];
                nums[end] = 2;
                end--;
            } else curr++;
        }
        return;
    }
}
