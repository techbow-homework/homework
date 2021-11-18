package com.techbow.homework.y2021.m10.qiangzhai;

public class checkUnique {
    public boolean checkUniqueChar(char[] chars) {
        //cc
        if (chars == null) {
            throw new IllegalArgumentException("try again!")
        }
        //
        int[] bitSet = new int[8];
        for (char c : chars) {
            int i = c / 32;
            int j = c % 32;
            if ((bitSet[i] & (1 << j)) != 0) {
                return false;
            } else {
                bitSet[i] |= 1 << j;
            }
        }
        return true;
    }
}
