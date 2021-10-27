package com.techbow.homework.y2021.m10.rantao;

public class binarySearch2 {
        public int search(int[] nums, int target) {
            if(nums.length==0) return -1;
            int l=0;
            int r=nums.length-1;

            while(l<r){
                int m=(l+r)/2;

                if(nums[m]<=nums[r]){
                    if(target>nums[m]&& target<=nums[r]){
                        l=m+1;
                    }
                    else{
                        r=m;
                    }
                }else{
                    if(target<=nums[m]&&target>=nums[l]){
                        r=m;
                    }
                    else{
                        l=m+1;
                    }
                }
            }
            if(nums[l]==target) return l;
            else return -1;
        }
    }

