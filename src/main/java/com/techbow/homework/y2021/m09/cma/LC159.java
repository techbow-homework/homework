package com.techbow.homework.y2021.m09.cma;

public class LC159 {
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            char ch1 = '\0', ch2 = '\0';
            int idx1 = -1, idx2 = -1;
            int left = 0, max = 0;
            int len = s.length();
            for(int right = 0; right< len; right ++){
                char ch = s.charAt(right);
                if (ch == ch1){
                    idx1 = right;
                } else if (ch == ch2){
                    idx2 = right;
                } else{
                    if(idx1 < idx2){
                        ch1 = ch;
                        left = idx1 + 1;
                        idx1 = right;
                    } else {
                        ch2 = ch;
                        left = idx2 + 1;
                        idx2 = right;
                    }
                }
                max = Math.max(max, right-left + 1);
            }
            return max;
        }
    }
}
