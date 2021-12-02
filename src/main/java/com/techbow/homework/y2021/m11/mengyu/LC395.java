package com.techbow.homework.y2021.m11.mengyu;

public class LC395 {
    //brutal force: get every substring and check for validity
    public int longestSubstringS1(String s, int k) {
        int res = 0;
        int[] chars = new int[26];
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                chars[s.charAt(end) - 'a']++;
                if (isValid(k, chars)) {
                    res = Math.max(res, end - start + 1);
                }
            }
        }
        return res;
    }
    private boolean isValid(int k, int[] countMap) {
        int countLetters = 0, countAtLeastK = 0;
        for (int freq : countMap) {
            if (freq > 0) countLetters++;
            if (freq >= k) countAtLeastK++;
        }
        return countAtLeastK == countLetters;
    }
}
