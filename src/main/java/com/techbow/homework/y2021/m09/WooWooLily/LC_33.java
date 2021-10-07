package com.techbow.homework.y2021.m09.WooWooLily;
import java.util.*;

// search in rotated sorted array
//assumptions & constraints: unique values, rotate 1x, return -1 when no target found
// input array + target number

// thoughts:
// two sorted subset, first sorted larger than second
// case 1: L < T < M | > Rsubset
// case 2: L < M | > T < Rsubset
// case 3: Lsubset | > M < T < R
// case 4: L subset | > T < M < R

public class LC_33 {

    public int search(int[] nums, int target) {
        //corner case
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else if (nums[mid] <= nums[right]){
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;



    }
    public static void main(String[] arg) {
        // test abv cases
        int[] nums = new int[] {3,4,5,1,2 };

        LC_33 test = new LC_33();
        System.out.println(test.search(nums,3));
        System.out.println(test.search(nums,2));
        System.out.println(test.search(nums, 4));

    }

    // binary search, every search half the candidates logN
    // extra space O(1)

}
