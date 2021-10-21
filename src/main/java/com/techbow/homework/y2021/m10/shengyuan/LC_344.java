package com.techbow.homework.y2021.m10.shengyuan;

public class LC_344 {
    public String reverse(String input) {
        //cc
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            swap(array, start++, end--);
        }
        return new String(array);
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        LC_344 test = new LC_344();
        String input = "abcde";
        String result = test.reverse(input);
        System.out.println(result);
    }
}
