package com.techbow.homework.y2021.m11.mengyu;

public class LC8StringToInt {
    public int myAtoi(String s) {
        //  +4193 with words
        //   i
        int pointer = 0;
        boolean isPositive = true;
        int res = 0;
        while (pointer < s.length() && s.charAt(pointer) == ' ') {
            pointer++;
        }
        if (pointer == s.length()) {
            return 0;
        }
        if (s.charAt(pointer) >= 'a' && s.charAt(pointer) <= 'z') {
            return 0;
        } else if (s.charAt(pointer) == '-') {
            isPositive = false;
            pointer++;
        } else if (s.charAt(pointer) == '+') {
            pointer++;
        }

        while (pointer < s.length()) {
            if (s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9') {
                // get the integer from the string using decimal representation of characters
                // '0' => 48  '2' => 50
                // so '2' - '0' = 2
                int number = s.charAt(pointer) - '0';
                // check if the res will overflow or not.
                if (res > (Integer.MAX_VALUE - number) / 10) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + number;
            } else {
                break;
            }
            pointer++;
        }
        return isPositive ? res : -1 * res;
    }
}
