package com.techbow.homework.y2021.m11.mengyu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1119RemoveVowels {
    public String removeVowels(String s) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        char[] sChar = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < sChar.length; fast++) {
            if (!vowelSet.contains(sChar[fast])) {
                sChar[slow] = sChar[fast];
                slow++;
            }
        }
        return new String(sChar, 0, slow);
    }
}
