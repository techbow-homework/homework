package com.techbow.homework.y2021.m09.tianhang;

public class LC_55 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        if(nums.length == 1) return true;
        boolean[] res = new boolean[nums.length];
        res[nums.length - 1] = true;
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = 1; j <= nums[i]; j++){
                if(i + j < nums.length && res[i + j]){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[0] == true;
    }
}
