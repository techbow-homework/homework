package com.techbow.homework.y2021.m09.QiyueWang;

public class LC647PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for(int i = 0; i < 2 * n - 1; i++){ // total 2n-1 pos for splits
            int left = i / 2;
            int right = (i + 1) / 2;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left --;
                right ++;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] input = new String[] {"abc", "aaa"}; // expect 3, 6
        for(String s : input) {
            int res = countSubstrings(s);
            System.out.println(res);

        }
    }
}
//time O(N) space O(1)