package com.techbow.homework.y2021.m11.mengyu;

public class LC26 {
    public int removeDuplicatesInPlace(int[] nums) {
        int s = 0;
        for (int f = 1; f < nums.length; f++) {
            if (nums[f] != nums[s]) {
                s++;
                nums[s] = nums[f];
            }
        }
        return s;
    }
}
