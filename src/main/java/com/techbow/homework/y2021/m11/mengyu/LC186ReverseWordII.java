package com.techbow.homework.y2021.m11.mengyu;

public class LC186ReverseWordII {
    public void reverseWords(char[] s) {
        //reverse the whole array first
        //then reverse each words inside the array
        int left = 0;
        int right = s.length - 1;
        reverse(s, left, right);
        reverseSingle(s);
    }
    private void reverse(char[] s, int left, int right) {
        //left and right pointers walk towards middle. swap the two
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
    private void reverseSingle(char[] s) {
        int slow = 0;
        for (int fast = 0; fast < s.length; fast++) {
            if (s[fast] != ' ' && fast < s.length) {
                slow = fast;
                while (fast < s.length && s[fast] != ' ') {
                    fast++;
                }
                reverse(s, slow, fast - 1);
            }
        }
    }
}
