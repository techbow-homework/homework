package com.techbow.homework.y2021.m10.shengyuan;

public class LC_186 {
    public String reverseWordsII(String str) {
        if (str == null || str.length() == 0) {
            return new String();
        }
        //str to char
        char[] array = str.toCharArray();
        int left = 0;
        int right = array.length - 1;
        reverse(array, left, right);
        int start = 0;
        for (int end = 0; end <= array.length; end++) {
            if (end == array.length || array[end] == ' ') {
                reverse(array, start, end - 1);
                start = end + 1;
            }
        }
        return new String(array);
    }
    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            swap(array, i++, j--);
        }
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        LC_186 test = new LC_186();
        String input = "the sky is blue";
        String result = test.reverseWordsII(input);
        System.out.println(result);
    }
}
