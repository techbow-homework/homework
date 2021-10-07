package com.techbow.homework.y2021.m10.shengyuan;

public class LC_53 {
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int len = array.length;
        int dp = array[0];
        int max = dp;
        for (int i = 1; i < len; i++) {
            if (dp > 0) {
                dp += array[i];
                if (dp > max) {
                    max = dp;
                }
            } else {
                dp = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
