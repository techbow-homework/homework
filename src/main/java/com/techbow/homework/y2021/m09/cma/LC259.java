package com.techbow.homework.y2021.m09.cma;
import java.util.*;
public class LC259 {
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int count = 0;
            int len = nums.length;
            for(int i = 0; i < len; i ++){
                int tar = target - nums[i];
                int left = i + 1;
                int right = len - 1;
                while(left < right){
                    if(nums[left] + nums[right] < tar){
                        // note here!
                        count += right - left;
                        left ++;
                    } else{
                        right --;
                    }
                }
            }
            return count;
        }
    }
}
