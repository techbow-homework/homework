package com.techbow.homework.y2021.m10.thomasxu;

import java.util.ArrayList;
import java.util.Arrays;

public class L300 {
    //S1: dp
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max_length = -1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max_length = Math.max(max_length, dp[i]);
        }
        return max_length;
    }

    //greedy
    public int lengthOfLIS2(int[] nums) {
        //cc
        ArrayList<Integer> subs = new ArrayList<>();
        subs.add(nums[0]);

        for(int i=1; i<nums.length;i++){
            int num = nums[i];
            if( num>subs.get(subs.size()-1)){
                subs.add(num);
            }else{
                int j=0;
                while(num>subs.get(j)){
                    j++;

                }
                subs.set(j, num);
            }
        }
        return subs.size();
    }

    // use bianry search to fasten the linear search  of  arraylist, so the complexity would be nlogn instead of n^2
    public int lengthOfLIS3(int[] nums) {
        //cc
        ArrayList<Integer> subs = new ArrayList<>();
        subs.add(nums[0]);

        for(int i=1; i<nums.length;i++){
            int num = nums[i];
            if( num>subs.get(subs.size()-1)){
                subs.add(num);
            }else{
                int j=binarySearch(subs,num);
                subs.set(j, num);
            }
        }
        return subs.size();
    }
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left =0;
        int right = sub.size() -1;

        while(left<right){
            int mid =  left + (right -left) /2 ;
            if(sub.get(mid)==num){
                return mid;
            }else if( sub.get(mid)<num){
                left= mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

