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
    public boolean isPalindrome1(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        LC_125 test = new LC_125();
        String input = "A man, a plan, a canal: Panama";
        test.isPalindrome(input);
        String input1 = "race a car";
        test.isPalindrome(input1);
        String input2 = " ";
        test.isPalindrome(input2);
    }
}
