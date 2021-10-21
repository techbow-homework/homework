package com.techbow.homework.y2021.m09.QiyueWang;

public class LC11ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int l = 0;
        int r = n - 1;
        int curH = height[0];
        while(l < r){
            if(height[l] <= height[r]){
                curH = height[l];
                l++;
            }else{
                curH = height[r];
                r--;
            }
            max = Math.max(curH * (r - l + 1), max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height)); // 49
    }
}
// time O(N) space O(1)
