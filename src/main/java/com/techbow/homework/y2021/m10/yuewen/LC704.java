package com.techbow.homework.y2021.m10.yuewen;

public class LC704 {//sol 1
    //corner case
    if(nums == null || nums.length == 0) {
        return -1 ;
    }
    int left = 0;
    int right = nums.length -1;
    int mid = 0;
    while(left<=right) {
        mid = left + (right - left)/2;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[mid] < target) {
            left = mid + 1;
        }
        if(nums[mid] > target) {
            right = mid - 1;
        }
    }return -1;

}
