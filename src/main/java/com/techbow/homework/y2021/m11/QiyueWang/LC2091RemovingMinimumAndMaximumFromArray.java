package com.techbow.homework.y2021.m11.QiyueWang;

public class LC2091RemovingMinimumAndMaximumFromArray {
    public static int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int maxIdx = 0;
        int max = nums[0];
        int min = nums[0];
        int minIdx = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < min){
                min = nums[i];
                minIdx = i;
            }else if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
        }
        int minToR = n - minIdx;
        int maxToR = n - maxIdx;
        if(maxIdx > minIdx){
            res = Math.min(Math.min(minIdx + 1 + maxToR, maxIdx + 1), minToR);
        }else{
            res = Math.min(Math.min(maxIdx + 1 + minToR, minIdx + 1), maxToR);
        }
        //System.out.println(minIdx+" "+maxIdx+" "+minToR+" "+maxToR);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,10,7,5,4,1,8,6};
        System.out.println(minimumDeletions(nums));//5
    }
}
