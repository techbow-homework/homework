package com.techbow.homework.y2021.m10.yeboyr;
//leetCode33:find target in rotated array
public class leet33 {
    class rotated {
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            int mid;

            while(start <= end){
                mid = start + (end-start)/2;
                if(nums[mid]==target) return mid;

                else if(nums[mid]>=nums[start]){
                    if(nums[mid]>target&&nums[start]<=target)
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
                else {
                    if (nums[mid]<target&&target<=nums[end])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }

            return -1;
        }
    }
}
