package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_28 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int k = needle.length();
        if (k == 0) return 0;
        for (int i = 0; i <= n - k; i++) {
            if (haystack.substring(i, i+k).equals(needle)) return i;
        }
        return -1;
    }
}
