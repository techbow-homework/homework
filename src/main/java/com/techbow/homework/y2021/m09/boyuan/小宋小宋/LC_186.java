package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_186 {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseWord(s);
    }
    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    private void reverseWord(char[] s) {
        int n = s.length;
        int start = 0;
        int end = 0;
        while (start < n) {
            while (end < n && s[end] != ' ') end++;
            reverse(s, start, end - 1);
            start = end + 1;
            end++;
        }
    }
}
