package com.techbow.homework.y2021.m10.LianjiangHe.BinarySearch;
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int counter = 0;
        while(left<right){
            int mid = left + (right - left)/2;
            if(nums[mid]<target){
                left++;
            }else if(nums[mid]>target){
                right--;
            }else{
                counter = counter ++;
                return mid;
            }
        }
        if(nums[right]<target){//submit的时候少了最右边界这一种特殊情况!!!
            return right+1;
        }else{
            return right;
        }
    }
}
