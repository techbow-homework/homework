package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_55 {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int reach = 0;
        for (int i = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(nums[i]+i, reach);
            if (reach >= nums.length-1) return true;
        }
        return false;
    }
}
