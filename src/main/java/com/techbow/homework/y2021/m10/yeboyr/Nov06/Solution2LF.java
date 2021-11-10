package com.techbow.homework.y2021.m10.yeboyr.Nov06;

class Solution2LF {
    public int binarySearch(int[]nums,int target){

        //conner case
        if(nums==null||nums.length==0) return -1;

        int mid = 0;
        int left = 0;
        int right = nums.length-1;

        while(left+1<right){
            mid = left + (right-left)/2; //Integer Overflow
            if(nums[mid]<target) left=mid;
            else right=mid;
        }

        if(nums[left]==target) return left;
        if(nums[right]==target) return left;
        return -1;
    }


}
