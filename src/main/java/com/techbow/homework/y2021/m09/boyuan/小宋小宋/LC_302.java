package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_302 {
    public int minArea(char[][] image, int x, int y) {
        int top = x;
        int bottom = x;
        int left = y;
        int right = y;
        for (x = 0; x < image.length; x++) {
            for (y = 0; y < image[0].length; y++) {
                if (image[x][y] == '1') {
                    top = Math.min(top, x);
                    bottom = Math.max(x+1, bottom);
                    left = Math.min(left, y);
                    right = Math.max(right, y+1);
                }
            }
        }
        return (right - left) * (bottom - top);
    }
}
