package com.techbow.homework.y2021.m11.shengyuan;

import java.util.HashSet;
import java.util.Set;

public class LC_1119 {
    public String removeVowels(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Set<Character> set = new HashSet<>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LC_1119 test = new LC_1119();
        String str = "leetcode";
        String res = test.removeVowels(str);
        System.out.println(res);
    }
}
