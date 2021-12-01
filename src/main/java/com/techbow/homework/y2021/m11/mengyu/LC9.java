package com.techbow.homework.y2021.m11.mengyu;

public class LC9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int invertHalf = 0;
        while (x > invertHalf) {
            invertHalf = invertHalf * 10 + x % 10;
            x /= 10;
        }
        return x == invertHalf || x == invertHalf / 10;
    }
}
