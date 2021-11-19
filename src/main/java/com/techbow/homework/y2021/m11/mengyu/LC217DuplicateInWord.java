package com.techbow.homework.y2021.m11.mengyu;

public class LC217DuplicateInWord {
    public boolean checkUnique (char[] chars) {
        //corner case
        if (chars == null) {
            throw new IllegalArgumentException("checkUnique has illegal argument");
        }
        int[] bitSet = new int[8];
        for (char ch : chars) {
            int rows = ch / 32;
            int cols = ch % 32;
            if ((bitSet[rows] & 1 << cols) != 0) {
                return false;
            }
            bitSet[rows] |= cols << 1;
        }
        return true;
    }

    public static void main(String[] args) {
        char[] testChar = {'a','b','c','d','e','f','g','h'};
        LC217DuplicateInWord test = new LC217DuplicateInWord();
        System.out.println(test.checkUnique(testChar));
    }
}
