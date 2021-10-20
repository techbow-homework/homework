package com.techbow.homework.y2021.m10.QiyueWang;

public class LC696CountBinarySubstrings {
    public static int countBinarySubstrings(String s) {
        int n = s.length();
        int prevLen = 0;
        int curLen = 1;
        int res = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                curLen ++;
            }else{
                res += Math.min(curLen, prevLen);
                prevLen = curLen;
                curLen = 1;
            }
        }
        return res + Math.min(prevLen, curLen);
    }

    public static void main(String[] args) {
        String s = "00110011";
        String s2 = "10101";
        System.out.println(countBinarySubstrings(s));// 6
        System.out.println(countBinarySubstrings(s2));// 4
    }
}
// time O(N) space O(1)
