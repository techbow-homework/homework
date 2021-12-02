package com.techbow.homework.y2021.m11.mengyu;

public class LC80RemoveDup {
    public int removeDuplicates(int[] nums) {
        //0 0 1 1 2 3 3 3
        //            s
        //                f
        //counter = 1
        int s = 0, count = 1;
        for (int f = 0; f < nums.length - 1; f++) {
            if (nums[f] == nums[f + 1] && count < 2) {
                nums[++s] = nums[f + 1];
                count++;
            }
            if (nums[f] != nums[f + 1]) {
                nums[++s] = nums[f + 1];
                count = 1;
            }
        }
        return s + 1;
    }
}
