package com.techbow.homework.y2021.m11.mengyu;

public class LC151ReverseWordsInAString {
    public String reverseWords(String s) {
        //"  I Love   A'Lester  "
        char[] sChar = s.toCharArray();
        int left = 0;
        int right = sChar.length;
        reverse(sChar, left, right);
        return reverseSingleWord(sChar);
    }
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
    }
    private String reverseSingleWord(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                //"  abc def  "
                slow = fast;
                while (chars[fast] != ' ') {
                    fast++;
                }
                reverse(chars, slow, fast - 1);
            }
        }
        return chars.toString();
    }
}
