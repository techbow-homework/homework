package com.techbow.homework.y2021.m09.shengyuan;

public class LC_344 {
    public String reverseString(String str) {
        if (str == null) {
            return null;
        }
        char[] array = str.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left++, right--);
        }
        return new String(array, 0, array.length);
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        LC_344 test = new LC_344();
        String str = "Igetoffer";
        String result = test.reverseString(str);
        System.out.println(result);
    }
}
