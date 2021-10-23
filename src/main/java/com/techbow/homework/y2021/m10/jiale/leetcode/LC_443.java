package com.techbow.homework.y2021.m10.jiale.leetcode;

/**
 * String Compression
 * Given an array of characters chars, compress it using the following algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * <p>
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * <p>
 * After you are done modifying the input array, return the new length of the array.
 * <p>
 * You must write an algorithm that uses only constant extra space.
 * <p>
 * ["a","a","b","b","c","c","c"]
 */
public class LC_443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;

        int count = 0;
        int slow = 0;
        int len = chars.length;
        for (int fast = 0; fast <= len; fast++) {
            if (fast == len || (fast != 0 && chars[fast] != chars[fast - 1])) {
                chars[slow++] = chars[fast - 1];
                if (count > 1) {
                    char[] countChar = String.valueOf(count).toCharArray();
                    for (int i = 0; i < countChar.length; i++) {
                        chars[slow++] = countChar[i];
                    }
                }
                count = 1;
            } else {
                count++;
            }
        }
        return slow;
    }
}
