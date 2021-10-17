package com.techbow.homework.y2021.m10.shengyuan;

public class LC_45 {
    public int canJump(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int minStep = 0;
        int prevRange = 0;
        int curRange = 0;
        for (int i = 0; i < array.length; i++) {
            if (curRange >= array.length - 1) {
                return minStep + 1;
            }
            if (i > prevRange) {
                prevRange = curRange;
                minStep++;
            }
            curRange = Math.max(curRange, i + array[i]);
        }
        return minStep;
    }
}
