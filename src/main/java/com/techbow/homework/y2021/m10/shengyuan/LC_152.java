package com.techbow.homework.y2021.m10.shengyuan;

public class LC_152 {
    public int maxProduct(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int preMax = array[0];
        int preMin = array[0];
        int max = array[0];
        int curMax;
        int curMin;

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            curMax = Math.max(Math.max(preMax * temp, preMin * temp), temp);
            curMin = Math.min(Math.min(preMax * temp, preMin * temp), temp);
            max = Math.max(curMax, max);
            preMax = curMax;
            preMin = curMin;
        }
        return max;
    }

    public static void main(String[] args) {
        LC_152 test = new LC_152();
        int[] input = {2, 3, -2, 4};
        int result = test.maxProduct(input);
        System.out.println(result);
    }
}
