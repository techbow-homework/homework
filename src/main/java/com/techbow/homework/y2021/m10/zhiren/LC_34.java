package com.techbow.homework.y2021.m10.zhiren;

public class LC_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if (nums == null || nums.length == 0){
            return ans;
        }

        //get range:

        ans[0] = bs1(nums,target);
        ans[1] = bs2(nums,target);
        return ans;
    }


    //get first position of the target

    public int bs1(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }

        int left = 0 , right = nums.length - 1, mid = 0;

        while (left+1<right){
            mid = left +(right - left)/2;
            if (nums[mid]<target){
                left = mid;

            }
            else {
                right = mid;
            }

        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    // get last position of the target:
    public int bs2(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }

        int left = 0 , right = nums.length - 1, mid = 0;

        while (left+1<right ){
            mid = left +(right - left)/2;
            if (nums[mid]<=target){
                left = mid;
            }
            else {
                right = mid;
            }

        }
        if (nums[right] == target) return right;
        if (nums[left] == target) return left;
        return -1;}

    public static void main(String[] args){
        LC_34 lc = new LC_34();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;


        System.out.println(lc.searchRange(nums,target));
    }
}


