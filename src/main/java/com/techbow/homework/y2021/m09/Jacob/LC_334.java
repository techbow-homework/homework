package com.techbow.homework.y2021.m09.Jacob;

public class LC_334 {

        public void reverseString(char[] s) {
            if (s == null || s.length < 1) return;

            int left = 0;
            int right = s.length -1;

            while(left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }
//用left和right双指针去走，然后左右swap。

