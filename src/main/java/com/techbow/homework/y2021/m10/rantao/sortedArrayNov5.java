package com.techbow.homework.y2021.m10.rantao;

public class sortedArrayNov5 {
    public int[] searchRange(int[] nums, int target) {
        //corner case
        int[] array = new int[] {-1,-1};
        if(nums.length == 0) return array;

        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        // 每次都给mid 赋值， 左右越过的时候， 最后m==target所在的位置就是解
        while( left  <= right) {
            mid = left + (right - left)/2;
            if(nums[mid] >= target) {
                right = mid -1;
            }else  {
                left = mid +1;
            }if(nums[mid] == target) {
                array[0] = mid;
            }}

        left = 0;
        right = nums.length -1;

        while( left <= right) {
            mid = left + (right - left)/2;

            if(nums[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            if(nums[mid] == target) {
                array[1] = mid;
            }}



        return array;
    }
}
