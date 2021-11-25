package com.techbow.homework.y2021.m11.mengyu;

import java.util.Arrays;

public class LC5 {
    public String longestPalindrome(String s) {
        //find all possible substrings
        String res = " ";
        for (int slow = 0; slow < s.length() - 1; slow++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(slow));
            for (int fast = slow + 1; fast < s.length(); ++fast) {
                sb.append(s.charAt(fast));
                String temp = sb.toString();
                if (checkIfIsPalindrome(temp) && temp.length() >= res.length()) {
                    res = temp;
                }
            }
        }
        if (res == " ") {
            return new String("" + s.charAt(0));
        }
        return res;
    }
    private boolean checkIfIsPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

