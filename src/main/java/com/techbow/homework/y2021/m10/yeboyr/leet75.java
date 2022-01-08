package com.techbow.homework.y2021.m10.yeboyr;

public class leet75 {
    class Solution {
        public void sortColors(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int curr = 0;
            int temp;

            while(curr<=right){
                if(nums[curr]==0){
                    temp = nums[left];
                    nums[left] = nums[curr];
                    nums[curr] = temp;
                    left++;
                    curr++;
                } else if(nums[curr]==2){
                    temp = nums[right];
                    nums[right] = nums[curr];
                    nums[curr] = temp;
                    right--;

                } else
                    curr++;
            }
        }
    }
}

/*
三指针做题，不用两边都动，记得用中间指针check；左边和中间交换后一起动，中间check，右边动：值交给中间check，再走while loop动；
 */
