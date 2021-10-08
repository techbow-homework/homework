package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.sort;

public class LC283MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }

        int pointer = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                swap(nums,pointer++,i);
            }
        }

    }

    public void swap(int nums[] , int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
}
