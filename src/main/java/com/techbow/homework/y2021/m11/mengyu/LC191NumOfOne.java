package com.techbow.homework.y2021.m11.mengyu;

public class LC191NumOfOne {
    public int hammingWeightS1(int n) {
        //mask <<
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
    public int hammingWeightS2(int n) {
        // input >> for loop
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (n == 0) return count;
            if ((n & 1) != 0) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
    public int hammingWeightS3(int n) {
        //input >> while loop
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 32;
        LC191NumOfOne test = new LC191NumOfOne();
        System.out.println(test.hammingWeightS2(a));
    }
}
