package com.techbow.homework.y2021.m10.rantao;
public class searchOct13 {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int l=0;
        int r=nums.length-1;

        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]==target) return true;
            if(nums[l]==target) return true;
            if(nums[r]==target) return true;

            if(nums[l]==nums[m]){
                l++;
            }
            else if(nums[r]==nums[m]){
                r--;
            }
            else if(nums[l]<nums[m]){
                if(target>nums[l]&&target<nums[m]){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }
            else{
                if(nums[m]<target && nums[r]>target){
                    l=m+1;
                }else {
                    r=m-1;}
            }

        }
        return false;
    }

}
