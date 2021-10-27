package com.techbow.homework.y2021.m10.jiale.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Reverse Words in a String
 */
public class LC_151 {
    public String reverseWords(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        System.out.println(new LC_151().reverseWords("a good   example"));
    }
}
