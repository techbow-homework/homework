package com.techbow.homework.y2021.m10.zekun;

import java.util.Arrays;

public class LC0016_TwoPointer_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        //cc
        if(nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int curSum = nums[i] + nums[start] + nums[end];
                if(curSum == target){
                    return target;
                }else if(Math.abs(curSum - target) < Math.abs(closest - target)){
                    closest = curSum;
                }
                if(curSum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return closest;
    }
}
