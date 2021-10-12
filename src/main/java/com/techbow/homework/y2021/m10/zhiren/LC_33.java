package com.techbow.homework.y2021.m10.zhiren;

public class LC_33 {
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) /2;

            if (nums[mid] >= nums[0] && target >= nums[0] || nums[mid] < nums[0] && target < nums[0]){
                //target and mid in same half
                if (nums[mid] < target) left = mid + 1;
                else right = mid;
            }else if ( nums[mid] >= nums[0]){
                left = mid + 1;
            }else right = mid - 1;
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args){
        LC_33 lc = new LC_33();
        int target = 0;
        //expected output 4
        int[] nums = new int[]{4,5,6,7,0,1,2};

        System.out.println(lc.search(nums,target));
    }
}
