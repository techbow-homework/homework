package com.techbow.homework.y2021.m11.mengyu;

public class LC3 {
     /*
public int lengthOfLongestSubstring(String s) {
        //abcabcbb
        //i
        //   j
        int res = 0;
        substrings:
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (noRepeat(s, i, j)) {
                        res = Math.max(res, j - i + 1);
                    } else {
                        continue substrings;
                    }

                }
            }
        return res;
    }
    private boolean noRepeat(String s, int start, int end) {
        int[] chars = new int[128];
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }
        return true;
    }
    */

    public int lengthOfLongestSubstring(String s) {
        //abcabcbb
        //   i
        //j
        int[] chars = new int[128];
        int res = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAtI = s.charAt(i);
            chars[charAtI]++;
            while (chars[charAtI] > 1) {
                char charAtJ = s.charAt(j);
                chars[charAtJ]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
