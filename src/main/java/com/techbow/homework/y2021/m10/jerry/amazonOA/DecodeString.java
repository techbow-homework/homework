package com.techbow.homework.y2021.m10.jerry.amazonOA;

import java.util.ArrayList;
import java.util.List;

public class DecodeString {
    public static List<Integer> frequency (String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        int[] freq = new int[26];
        int index = s.length() - 1;
        int count = 0;

        while (index >= 0) {
            if (s.charAt(index) == ')') {
                index--;
                while (s.charAt(index) != '(') {
                    count = (s.charAt(index) - '0') * 10 + count;
                    index--;
                }
                index--;
            } else if (s.charAt(index) == '#') {
                index--;
                int letter = ((s.charAt(index - 1) - '0') * 10) + (s.charAt(index) - '0') - 1;
                freq[letter] += count;
                count = 0;
                index -= 2;
            } else {
                int letter = s.charAt(index) - '0';
                freq[letter]++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i : freq) {
            result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(DecodeString.frequency("1226#24#"));
    }
}
