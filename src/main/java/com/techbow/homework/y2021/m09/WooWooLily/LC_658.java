package com.techbow.homework.y2021.m09.WooWooLily;
import java.util.*;
//find k closest #
// 1 2 3 4 5  find 2 of cloest to 4 [3,5]
public class LC_658 {
    public List<Integer> findKCloset(int[] nums, int k, int x) {
        if(nums == null || nums.length == 0) return null;
        int left = 0, right = nums.length - 1;
        int mid = 0;
        List<Integer> res = new ArrayList<>();

        //find left and right edges of clost to x
        while(left + 1 < right) {
            mid = left + (right - left) / 2;

            if(nums[mid] > x) {
                right = mid;
            }
            else {
                left = mid;
            }

        }

        for(int i = 0; i < k; i++) {
            if(left >= 0 && right <= nums.length - 1) {
                if (Math.abs(x - nums[left]) <= Math.abs(x - nums[right])){
                    left--;
                }
                else {
                    right++;
                }
            }
            else if (left < 0) {
                right++;
            }
            else {
                left--;
            }
        }

        //left is in the position before actual # to be included
        int start = left<0 ? 0 : left+1;
        for(int i = 0; i < k ; i++){
            res.add(nums[start+i]);
        }

        return res;

    }


}
