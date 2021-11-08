package com.techbow.homework.y2021.m10.yeboyr.Nov06;

class Solution2LF {
    public int binarySearch(int[]nums, int target){
        //conner case
        if (nums==null || nums.length==0) return -1;

        int left=0;
        int pivot=0;
        int right= nums.length-1;

        while(left+1<right){
            pivot = left+(right-left)/2; //IO
            if(nums[pivot]<target) left=pivot;
            right=pivot;
        }
        if(nums[left]==target) return left;
        if(nums[right]==target) return right;

        return -1;
    }

}
