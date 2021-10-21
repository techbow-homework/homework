package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_326 {
    public boolean isPowerOfThree(int n) {
        long musk = 1;
        while (musk < n) {
            musk = musk * 3;
        }
        if (musk == n) return true;
        else return false;
    }
}
