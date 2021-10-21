package com.techbow.homework.y2021.m10.shengyuan;

public class LC_28 {
    public int strStr(String s1, String s2) {
        //cc
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return -1;
        }
        //如果s1長度小於s2長度，則反過來
        if (s1.length() < s2.length()) {
            strStr(s2, s1);
        }
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            int j = 0;
            while (j< s2.length() && s1.charAt(i + j) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        LC_28 test = new LC_28();
        String str1 = "abcdefgabefg";
        String pattern = "efg";
        int result = test.strStr(str1, pattern);
        System.out.println(result);
    }
}
