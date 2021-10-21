package com.techbow.homework.y2021.m10.shengyuan;

public class LC_125 {
    public boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
