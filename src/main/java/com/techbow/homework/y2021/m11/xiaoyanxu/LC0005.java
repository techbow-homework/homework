package com.techbow.homework.y2021.m11.xiaoyanxu;

public class LC0005 {

    public String longestPalindrome(String s) {
        //cc
        if(s == null || s.length() == 0) return s;

        int len = s.length();
        int maxLen = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        for(int i = 0; i < len; i++){
            int l = i;
            int r = i;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            int size = r - l - 1;
            if(size > maxLen){
                maxLen = size;
                leftIdx = l + 1;
                rightIdx = r;
            }

            l = i;
            r = i + 1;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            size = r - l - 1;
            if(size > maxLen){
                maxLen = size;
                leftIdx = l + 1;
                rightIdx = r;
            }
        }

        return s.substring(leftIdx, rightIdx);
    }
}
