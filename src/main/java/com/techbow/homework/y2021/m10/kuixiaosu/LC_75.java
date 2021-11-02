package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_75 {
    public void sortColors(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) return;
        int min = 0;
        int max = nums.length - 1;
        int i = 0;
        while (min <= max) {
            if (nums[min] == 0) {
                swap(nums, min, i);
                min++;
                i++;
            } else if (nums[min] == 1) min++;

            else {
                swap(nums, max, min);
                max--;
            }
        }
    }
}
