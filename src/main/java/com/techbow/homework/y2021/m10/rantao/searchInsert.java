package com.techbow.homework.y2021.m10.rantao;

public class searchInsert {
    public int searchInsert1(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int m=(l+h)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                h=m-1;
            }else if(nums[m]<target){
                l=m+1;
            }
        } return l;
    }
}
