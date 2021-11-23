package com.techbow.homework.y2021.m11.shengyuan;

import java.util.HashMap;
import java.util.Map;

public class LC_242 {
    //S1: int[26]
    public boolean ifAnagram(String s1, String s2) {
        //cc
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            nums[s1.charAt(i) - 'a']++;
            nums[s2.charAt(i) - 'a']--;
        }
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
    //S2: HashMap
    public boolean ifAnagram1(String s1, String s2) {
        //cc
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        for (char c1: char1) {
            if (!map.containsKey(c1)) {
                map.put(c1, 1);
            } else {
                map.put(c1, map.get(c1) + 1);
            }
        }
        for (char c2 : char2) {
            if (map.containsKey(c2)) {
                if (map.get(c2) == 1) {
                    map.remove(c2);
                } else {
                    map.put(c2, map.get(c2) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LC_242 test = new LC_242();
        String str1 = " cat";
        String str2 = "rat";
        boolean result = test.ifAnagram(str1, str2);
        System.out.println(result);
    }
}
