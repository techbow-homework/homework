package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.HashMap;
import java.util.Map;

//Find all scatter palindrome strings inside given string. A scatter palindrome is defined as a string in which characters can be shuffled to obtain a palindrome.
//
//        Example:
//
//        Input: "aabb"
//        Output: [a, aa, aab, aabb, a, abb, b, bb, b], total 9 substrings


public class ScatterPalindrome {
    private static long getCount(String s){
        int n = s.length();
        int answer = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0,1);
        // a Hyperdrome string is a string that has at most one letter that occurs an odd number of times.
        int x = 0;
        for (char c : s.toCharArray()) {
            int d = c - 'a';
            x ^= 1 << d;
            answer = answer + m.getOrDefault(x,0); // how many times it was seen, corresponding to the number of even-length Hyperdrome that ends here
            for (int i = 0; i < 26; ++i) {
                int num = x ^ (1 << i); // flip the bit, and see how many times it was seen
                answer += m.getOrDefault(num,0); // corresponding to the number of odd-length Hyperdrome that ends here
            }
            m.put(x, m.getOrDefault(x,0) + 1);
        }

        return answer;

    }

    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "bbrrg";
        System.out.println(getCount(s1)); // 4
        System.out.println(getCount(s2)); // 12
    }
}
