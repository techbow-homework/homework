package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Arrays;

public class LC1235MaximumProfitInJobScheduling {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int dp[] = new int[n];
        for(int i = 0; i < n; i++){
            int prev = binarySearch(jobs, i);
            if(i == 0) dp[i] = jobs[0][2];
            else{
                dp[i] = Math.max(dp[i - 1], (prev >= 0 ? dp[prev] : 0) + jobs[i][2]); // choose or not
            }
        }
        return dp[n - 1];
    }
    private static int binarySearch(int[][] jobs, int i){
        int l = 0;
        int r = i - 1;
        while(l < r){
            int mid = (l + r + 1) / 2;
            if(jobs[mid][1] <= jobs[i][0]) l = mid; // if prev end time <= cur start time
            else{
                r = mid - 1;
            }
        }
        if(jobs[l][1] <= jobs[i][0]) return l;//in case l not changed
        return -1;
    }

    public static void main(String[] args) {
        int[] st = new int[]{1,2,3,3};
        int[] et = new int[]{3,4,5,6};
        int[] profit = new int[] {50,10,40,70};
        System.out.println(jobScheduling(st,et,profit));//120
        int[] st2 = new int[]{1,2,3,4,6};
        int[] et2 = new int[]{3,5,10,6,9};
        int[] profit2 = new int[] {20,20,100,70,60};
        System.out.println(jobScheduling(st2,et2,profit2));//150
    }
}
