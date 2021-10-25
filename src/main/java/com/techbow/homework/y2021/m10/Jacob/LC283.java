package com.techbow.homework.y2021.m10.Jacob;

public class LC283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int s = 0;
        int f = 0;
        while (f < nums.length) {
            if(nums[f] != 0) { //if f != 0
                nums[s++] = nums[f]; // //把nums[f]的值赋给s；
            }
            f++;
        }
        //change the rest numbers to all 0.
        while (s < nums.length) {
            nums[s++] = 0; //把s指针后面的数值变成0；
        }
    }
}

