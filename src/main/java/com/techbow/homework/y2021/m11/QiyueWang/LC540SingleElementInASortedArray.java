package com.techbow.homework.y2021.m11.QiyueWang;

public class LC540SingleElementInASortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] != nums[1]) return nums[0];
        if(nums[n - 1] != nums[n - 2]) return nums[n - 1];
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3,4,4,5,5};
        int[] nums2 = new int[]{3,3,4,4,5,6,6};
        System.out.println(singleNonDuplicate(nums));//2
        System.out.println(singleNonDuplicate(nums2)); // 5
    }
}
// time O(logN) space O(1)
