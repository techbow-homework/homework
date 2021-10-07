package com.techbow.homework.y2021.m09.cma;

public class LC055 {
    class Solution {
        public boolean canJump(int[] nums){
            if(nums == null || nums.length == 0) return true;
            int maxRange = nums[0];
            for(int i = 0; i < nums.length; i++){
                if(maxRange < i) return false;
                maxRange = Math.max(maxRange, nums[i] + i);
                if(maxRange >= nums.length-1) return true;
            }
            return false;
        }
    }
}
