package com.techbow.homework.y2021.m10.shengyuan;

public class LC_709 {
    public String toLowerCase(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 65 && array[i] <= 91) {
                array[i] += 32;
            }
        }
        return new String(array);
    }
    public static void main(String[] args) {
        LC_709 test = new LC_709();
        String input = "BTgFS";
        String res = test.toLowerCase(input);
        System.out.println(res);
    }
}
