package com.techbow.homework.y2021.m10.yeboyr;

public class leetcode283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0;
            int j = 0;
            int temp;

            for(i = 0; i<nums.length; i++){
                if(nums[i]!=0){
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                }
            }
        }
    }
}

/*
不可以直接赋值0，要考虑没有0存在的情况，使用temp来周转；
 */
