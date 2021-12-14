package com.techbow.homework.y2021.m10.zekun;

public class LC0011_RainContainer {
    public int maxArea(int[] height) {
        //cc
        int res = 0;
        if(height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            if(height[left] < height[right]){
                res = Math.max(res, (right - left) * height[left]);
                left++;
            }else{
                res = Math.max(res, (right - left) * height[right]);
                right--;
            }
        }
        return res;
    }
}
