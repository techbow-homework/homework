package com.techbow.homework.y2021.m11.shengyuan;

public class LC_5 {
    public String longestPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int[] max = new int[1];
        int[] result = new int[2];
        for (int i = 0; i < str.length() - 1; i++) {
            findMax(str, i, i, max, result);
            findMax(str, i, i + 1, max, result);
        }
        return str.substring(result[0], result[1]);
    }
    private void findMax(String str, int left, int right, int[] max, int[] result) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        int dist = right - left - 1;
        if (dist > max[0]) {
            max[0] = dist;
            result[0] = left + 1;
            result[1] = right;
        }
    }
    public static void main(String[] args) {
        LC_5 test = new LC_5();
        String str1 = "babad";
        String str2 = "cbbd";
        String str3 = "a";
        String str4 = "ac";
    }
}
