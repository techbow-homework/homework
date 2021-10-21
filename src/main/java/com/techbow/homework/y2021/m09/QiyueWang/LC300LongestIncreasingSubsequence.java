package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC300LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //int max = nums[0];
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for(int i = 1; i < n; i++){
            if(nums[i] > res.get(res.size() - 1)){
                res.add(nums[i]);
            }else if(nums[i] < res.get(res.size() - 1)){
                int index = binarySearch(res, nums[i]);
                res.set(index, nums[i]);
            }
        }
        //System.out.println(res.toString());
        return res.size();
    }

    private static int binarySearch(List<Integer> res, int val){ // upperbound index
        if(val <= res.get(0)){
            return 0;
        }
        int left = 0;
        int right = res.size() - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(res.get(mid) == val) return mid;
            else if(res.get(mid) < val) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int[] nums2 = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums)); // 4
        System.out.println(lengthOfLIS(nums2)); // 4
    }
}
// time O(NlogN) space O(N)