package com.techbow.homework.y2021.m10.jiale.leetcode;

/**
 * Reverse String
 * idea: two pointer start from both sides, check for different characters and swap them, the end condition will be left <= right, one path O(n)
 */
public class LC_344 {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            swap(s, left++, right--);
        }
    }

    private void swap(char[] arr, int left, int right) {
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
